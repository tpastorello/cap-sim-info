package com.vinteum.cap.siminfo;

import android.content.Context;
import android.Manifest;
import android.telephony.TelephonyManager;

import androidx.annotation.RequiresPermission;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

/*
@CapacitorPlugin(name = "SimInfo")
public class SimInfoPlugin extends Plugin {

    private SimInfo implementation = new SimInfo();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
*/

@CapacitorPlugin(name = "SimInfo", permissions = {@Permission(strings = {Manifest.permission.READ_PHONE_STATE}, alias = "phoneState")})
public class SimInfoPlugin extends Plugin {

    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    @PluginMethod
    public void getSimInfo(PluginCall call) {
        Context context = getContext();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        JSObject ret = new JSObject();
        ret.put("countryIso", telephonyManager.getSimCountryIso());
        ret.put("operator", telephonyManager.getSimOperator());
        ret.put("operatorName", telephonyManager.getSimOperatorName());
        ret.put("serialNumber", telephonyManager.getSimSerialNumber());
        call.resolve(ret);
    }
}