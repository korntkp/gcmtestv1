package com.example.vasic171.gcmtestv1.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by tanakp49 on 25/07/2559.
 */
public class MyDialog extends Activity {
    private static final String TAG = "Creating Dialog";
    private static final String DATA_TITLE = "title";
    private static final String DATA_BODY = "body";
    private static final String DATA_ICON = "icon";

    private Context context;

    public MyDialog(Context context) {
        this.context = context;
    }

    public void createDialog(Bundle bundle) {
        Log.e(TAG, "In Createialog");

        String dialogTitle =  bundle.getString(DATA_TITLE);
        String dialogBody =  bundle.getString(DATA_BODY);
        String dialogIcon =  bundle.getString(DATA_ICON);

        Log.e(TAG, "Title : " + dialogTitle);
        Log.e(TAG, "Body : " + dialogBody);
        Log.e(TAG, "Icon : " + dialogIcon);

////        setTheme(android.R.style.Theme_Dialog);
////        http://stackoverflow.com/questions/2147144/android-how-to-display-a-dialog-over-a-native-screen
////        http://stackoverflow.com/questions/8766739/show-an-alert-dialog-in-broadcast-receiver-after-a-system-reboot
//
//        Handler handler = new Handler(Looper.getMainLooper());
//        handler.post(new Runnable() {
//            @Override
//            public void run()
//            {
//                String dialogTitle =  bundle.getString(DATA_TITLE);
//                String dialogBody =  bundle.getString(DATA_BODY);
//                String dialogIcon =  bundle.getString(DATA_ICON);
//
//                Log.e(TAG, "Title : " + dialogTitle);
//                Log.e(TAG, "Body : " + dialogBody);
//                Log.e(TAG, "Icon : " + dialogIcon);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//                builder.setTitle(dialogTitle);
//                builder.setMessage(dialogBody);
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        Toast.makeText(getApplicationContext(),
//                                "OK!!!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //dialog.dismiss();
//                    }
//                });
//                builder.show();
//            }
//        });
    }
}
