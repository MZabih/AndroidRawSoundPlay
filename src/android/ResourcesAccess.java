package cordova.plugins.resources.access;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;

import com.myApp.starter.MainActivity;
import com.myApp.starter.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.apache.cordova.media.AudioHandler.TAG;

/**
 * This class echoes a string called from JavaScript.
 */

public class ResourcesAccess extends CordovaPlugin {
    public Activity activity;
    android.content.res.Resources res;
    public static MediaPlayer mediaPlayer;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(args.getString(0));
            return true;
        }
        else if (action.equals("listRaw")) {
            JSONArray o = this.listRaw();

            callbackContext.success(o);
            return true;
        }
        else{
            this.stopMediaPlayer();
            return true;
        }
        return false;
    }
    protected void onCreate(Bundle savedInstanceState) {
    }
    public void onAttach(Activity activity) {
        this.activity = activity;
    }
    private JSONArray listRaw(){
        Field[] fields=R.raw.class.getFields();
        JSONArray soundList = new JSONArray();
        for(int count=0; count < fields.length; count++){
            Log.i("Raw Asset: ", fields[count].getName());
            soundList.put(fields[count].getName());
        }
        return soundList;
    }
    private void coolMethod(String data) {
        Context context = this.cordova.getActivity().getApplicationContext();
        res=context.getResources();
        int resID = res.getIdentifier(data ,"raw", context.getPackageName());

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(context,resID);
        mediaPlayer.start();
    }
    private void stopMediaPlayer() {
            mediaPlayer.stop();
    }
}
