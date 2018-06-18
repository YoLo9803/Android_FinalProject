package com.example.f9898.androidfinal;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;

import android.os.IBinder;
import android.support.annotation.Nullable;

public class MediaPlayService extends Service{

    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this, R.raw.call_me_maybe);
        player.start();

        return super.onStartCommand(intent, flags, startId);
    }
}

