package com.wizion.androidarchitecturecomponentsandjetpack.services

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityServiceBinding
    private val binding : ActivityServiceBinding
        get()= _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Service
        binding.btnStartService.setOnClickListener {
            startService(Intent(this@ServiceActivity,MusicService::class.java))
        }
        binding.btnStopService.setOnClickListener {
            stopService(Intent(this@ServiceActivity,MusicService::class.java))
        }


        //Alarm Manager
        binding.btnSetAlarm.setOnClickListener {
            val alarmManager : AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val time : Int = Integer.parseInt( binding.edttime.text.toString())
            val triggerTime : Long = System.currentTimeMillis()+(time*1000)
            val iBroadcast : Intent = Intent(this@ServiceActivity,MyBroadcastReceiver::class.java)
            val pi : PendingIntent = PendingIntent.getBroadcast(this@ServiceActivity,100,iBroadcast,PendingIntent.FLAG_UPDATE_CURRENT)
            alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi)
        }

        //SMS APP

    }
}