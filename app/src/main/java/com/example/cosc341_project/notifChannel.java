package com.example.cosc341_project;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;


public class notifChannel extends Application { // Notification Channel that runs as soon as app starts as per: https://developer.android.com/develop/ui/views/notifications/build-notification

    public static final String CHANNEL_ID_1 = "channel";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    // Notification channel with importance
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID_1, "channel", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("channel description");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
