package org.icare.devcon.icare;

import android.app.Application;

import com.pushbots.push.Pushbots;

/**
 * Created by Sasikanth on 2/15/15.
 */
public class MyApplication extends Application {
    private String SENDER_ID = "181170534325";
    private String PUSHBOTS_APPLICATION_ID = "543950b21d0ab1e9798b458f";

    @Override
    public void onCreate() {
        super.onCreate();
        Pushbots.init(this, SENDER_ID, PUSHBOTS_APPLICATION_ID);
        //Pushbots.getInstance().setMsgReceiver(CustomPushReciver.class);

    }
}
