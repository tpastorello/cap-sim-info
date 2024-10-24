package com.vinteum.cap.siminfo;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import android.os.Build;
import android.app.Activity;

import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.JSObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@CapacitorPlugin(name = "SimInfo")
public class SimInfo extends Plugin {

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        if (value == null) {
            call.reject("Must provide a value");
            return;
        }

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
    }

    @PluginMethod
    public void getSimInfo(PluginCall call) {
        Context context = getContext();
        Activity activity = getActivity();

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            call.reject("Permission denied");
            return;
        }

        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
        List<SubscriptionInfo> subscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
        JSONArray simArray = new JSONArray();

        if (subscriptionInfoList != null && !subscriptionInfoList.isEmpty()) {
            for (SubscriptionInfo subscriptionInfo : subscriptionInfoList) {
                JSONObject simInfo = new JSONObject();
                try {
                    simInfo.put("carrierName", subscriptionInfo.getCarrierName());
                    simInfo.put("displayName", subscriptionInfo.getDisplayName());
                    simInfo.put("countryIso", subscriptionInfo.getCountryIso());
                    simInfo.put("iccId", subscriptionInfo.getIccId());
                    simInfo.put("simSlotIndex", subscriptionInfo.getSimSlotIndex());

                    // Attempt to get the phone number for each SIM using createForSubscriptionId
                    String phoneNumber = "Unavailable";
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                        TelephonyManager telephonyManager = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
                                .createForSubscriptionId(subscriptionInfo.getSubscriptionId());
                        phoneNumber = telephonyManager.getLine1Number(); // Get the phone number for the specific SIM
                    } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                        // For older devices that do not support createForSubscriptionId
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                        phoneNumber = telephonyManager.getLine1Number();
                    } else {
                        phoneNumber = "Number unavailable on Android 11+ for privacy reasons";
                    }

                    simInfo.put("phoneNumber", phoneNumber != null ? phoneNumber : "Number unavailable");

                    simArray.put(simInfo);
                } catch (Exception e) {
                    call.reject("Failed to retrieve SIM info", e);
                    return;
                }
            }
        }

        JSObject ret = new JSObject();
        ret.put("simInfo", simArray);
        call.resolve(ret);
    }
}
