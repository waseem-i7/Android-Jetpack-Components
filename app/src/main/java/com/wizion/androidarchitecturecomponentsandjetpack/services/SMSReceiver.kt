package com.wizion.androidarchitecturecomponentsandjetpack.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.util.Log

class SMSReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle: Bundle? = intent?.extras
        val smsObj = bundle?.get("pdus") as Array<*>

        for (obj in smsObj) {
            val message = SmsMessage.createFromPdu(obj as ByteArray)
            Log.e("MessageDetails","Mobile : ${message.displayOriginatingAddress}\nMessage : ${message.displayMessageBody}")
        }

        val smsManager = SmsManager.getDefault()

        smsManager.sendTextMessage("+919837819886",null,"Hello", null,null)
    }
}