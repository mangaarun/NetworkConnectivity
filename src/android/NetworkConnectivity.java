package ionic.check.network.connectivity;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * This class echoes a string called from JavaScript.
 */
public class NetworkConnectivity extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isConnected")) {
           // String message = args.getString(0);
           // this.isConnected(message, callbackContext);
            this.isConnected(callbackContext);
            return true;
        }
        return false;
    }

   

    private void isConnected(CallbackContext callbackContext){
        try{
            ConnectivityManager connectivityManager 
            = (ConnectivityManager) cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean connected =  activeNetworkInfo != null && activeNetworkInfo.isConnected();
            if(connected)                
                callbackContext.success("true");
            else
                callbackContext.success("false");
        }
        catch (Exception e) {
            callbackContext.error(e.getMessage());
        }
    }
}
