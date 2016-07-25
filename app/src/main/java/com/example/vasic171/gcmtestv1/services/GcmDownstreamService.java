package com.example.vasic171.gcmtestv1.services;

import android.os.Bundle;
import android.util.Log;

import com.example.vasic171.gcmtestv1.views.MyDialog;
import com.example.vasic171.gcmtestv1.views.MyNotification;
import com.google.android.gms.gcm.GcmListenerService;

public class GcmDownstreamService extends GcmListenerService {
    private static final String TAG = "DcmDownStreamService";

    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        Log.e(TAG, "Message Incoming");
        Log.d(TAG, bundle.toString());

        Bundle notificationBundle = bundle.getBundle("notification");
        String body = bundle.getString("body");

//        for (String key : bundle.keySet()) {
//            Object value = bundle.get(key);
//            Log.d(TAG, String.format("%s: %s (%s)",
//                    key,
//                    value.toString(),
//                    value.getClass().getName()));
//        }
        if (notificationBundle != null) {
            MyNotification myNotification = new MyNotification(GcmDownstreamService.this);
            myNotification.createPushNotification(notificationBundle);
        } else if (body != null) {
            Log.e(TAG, "Do CreateDialog");
            MyDialog myDialog = new MyDialog(GcmDownstreamService.this);
            myDialog.createDialog(bundle);
        }
    }
}
