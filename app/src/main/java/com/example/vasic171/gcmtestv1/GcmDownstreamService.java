package com.example.vasic171.gcmtestv1;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

public class GcmDownstreamService extends GcmListenerService {
    private static final String TAG = "DcmDownStreamService";

    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        Log.e(TAG, "Message Incoming");
//        Bundle notificationData = bundle.getBundle("notification");
//        Log.e(TAG, "Title : " + notificationData.getString("title"));
//        Log.e(TAG, "Body : " + notificationData.getString("body"));
//        Log.e(TAG, "icon : " + notificationData.getString("ic_launcher"));
    }
}
