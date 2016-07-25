package com.example.vasic171.gcmtestv1.views;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.vasic171.gcmtestv1.R;
import com.example.vasic171.gcmtestv1.activities.MainActivity;

/**
 * Created by tanakp49 on 25/07/2559.
 */
public class MyNotification {
    private static final String TAG = "Creating Notification";
    private static final String DATA_TITLE = "title";
    private static final String DATA_BODY = "body";
    private static final String DATA_ICON = "icon";

    private Context context;

    public MyNotification(Context context) {
        this.context = context;
    }

    public void createPushNotification(Bundle notificationBundle) {
        String notificationTitle =  notificationBundle.getString(DATA_TITLE);
        String notificationBody =  notificationBundle.getString(DATA_BODY);
        String notificationIcon =  notificationBundle.getString(DATA_ICON);

        Log.e(TAG, "Title : " + notificationTitle);
        Log.e(TAG, "Body : " + notificationBody);
        Log.e(TAG, "Icon : " + notificationIcon);

        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(notificationTitle)
                .setContentText(notificationBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    public void callLocalNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1000, mBuilder.build());
    }
}
