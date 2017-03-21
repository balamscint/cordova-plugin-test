/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package tech.gnb.test;


import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class launches the camera view, allows the user to take a picture, closes the camera view,
 * and returns the captured image.  When the camera view is closed, the screen displayed before
 * the camera view was shown is redisplayed.
 */
public class Test extends CordovaPlugin {

    /*@Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // your init code here
    }*/

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  A PluginResult object with a status and message.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)  throws JSONException{

        JSONObject r = new JSONObject();
        PluginResult result;
        boolean b=true;
        try {
            if (action.equalsIgnoreCase("test")) {
                String str = args.getString(0);
                r.put("response", str);
                //callbackContext.success(r);
                result = new PluginResult(PluginResult.Status.OK, r);
            } else {
                b=false;
                result = new PluginResult(PluginResult.Status.ERROR, "Invalid Action");
            }
        }catch (JSONException e){
            e.printStackTrace();
            b=false;
            result = new PluginResult(PluginResult.Status.ERROR, "JSON Error");
        }

        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);

        /*
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                ...
                callbackContext.success(); // Thread-safe.
            }
        });

        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                ...
                callbackContext.success(); // Thread-safe.
            }
        });
        */
        return b;
    }
}
