package com.wizion.androidarchitecturecomponentsandjetpack.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings

class MyBroadcastReceiver : BroadcastReceiver() {

    lateinit var mp : MediaPlayer

    override fun onReceive(context: Context?, intent: Intent?) {
        mp = MediaPlayer.create(context,Settings.System.DEFAULT_RINGTONE_URI)
        mp.isLooping = true
        mp.start()
    }
}