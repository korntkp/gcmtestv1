package com.example.vasic171.gcmtestv1;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

public class GcmTokenRefreshService extends InstanceIDListenerService {

    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, GcmRegisterService.class);
        startActivity(intent);
    }
}
