package com.vinteum.cap.siminfo;

import android.content.Context;
import android.telephony.TelephonyManager;
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

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = null;
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            phoneNumber = "Number unavailable on recent versions of Android for privacy reasons";
        } else {            
            phoneNumber = telephonyManager.getLine1Number();
        }

        JSObject ret = new JSObject();
        ret.put("phoneNumber", phoneNumber != null ? phoneNumber : "Number unavailable");
        call.resolve(ret);
    }
}
