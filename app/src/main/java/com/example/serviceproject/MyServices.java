package com.example.serviceproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class MyServices extends Service {
    private MediaPlayer Player;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Player= MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        Player.setLooping(true);
        Player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Player.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
