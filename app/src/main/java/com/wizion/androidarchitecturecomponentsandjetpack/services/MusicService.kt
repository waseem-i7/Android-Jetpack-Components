package com.wizion.androidarchitecturecomponentsandjetpack.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MusicService : Service() {
    lateinit var mp : MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)
        mp.isLooping = true
        mp.start()
        return START_STICKY
    }

    override fun onDestroy() {
        mp.stop()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}