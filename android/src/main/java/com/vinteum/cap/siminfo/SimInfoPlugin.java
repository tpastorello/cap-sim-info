package com.vinteum.cap.siminfo;

import com.getcapacitor.PluginCall;
import com.getcapacitor.JSObject;

public class SimInfoPlugin {

    private SimInfo implementation = new SimInfo();
    
    public void callEcho(PluginCall call) {
        String value = call.getString("value");
        if (value != null) {            
            implementation.echo(call);
        } else {
            call.reject("Value is missing");
        }
    }
}
