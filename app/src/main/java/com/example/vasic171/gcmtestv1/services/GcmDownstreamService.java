package com.example.vasic171.gcmtestv1.services;

import android.os.Bundle;
import android.util.Log;

import com.example.vasic171.gcmtestv1.views.MyDialog;
import com.example.vasic171.gcmtestv1.views.MyNotification;
import com.google.android.gms.gcm.GcmListenerService;

public class GcmDownstreamService extends GcmListenerService {
    private static final String TAG = "DcmDownStreamService";
    private static final String DATA_TITLE = "title";
    private static final String DATA_BODY = "body";
    private static final String DATA_ICON = "icon";

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
            String notificationTitle =  notificationBundle.getString(DATA_TITLE);
            String notificationBody =  notificationBundle.getString(DATA_BODY);
            String notificationIcon =  notificationBundle.getString(DATA_ICON);

            Log.e(TAG, "Title : " + notificationTitle);
            Log.e(TAG, "Body : " + notificationBody);
            Log.e(TAG, "Icon : " + notificationIcon);

            MyNotification myNotification = new MyNotification(GcmDownstreamService.this);
            myNotification.createPushNotification(notificationTitle, notificationBody, notificationIcon);
        } else if (body != null) {
            Log.e(TAG, "Do CreateDialog");
            MyDialog myDialog = new MyDialog(GcmDownstreamService.this);
            myDialog.createDialog(bundle);
        }
    }
}
