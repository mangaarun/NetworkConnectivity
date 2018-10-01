package ionic.check.network.connectivity;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class NetworkConnectivity extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("network")) {
            String message = args.getString(0);
            this.network(message, callbackContext);
            return true;
        }
        return false;
    }

    private void network(String message, CallbackContext callbackContext) {
		cordova.getActivity().runOnUiThread(new Runnable(){
			public void run(){
				final android.widget.Toast toast = android.widget.Toast.makeText(
					cordova.getActivity().getWindow().getContext(),
					message,
					android.widget.Toast.LENGTH_LONG,
				);
				toast.show();
			}
		});
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
