package com.wizion.androidarchitecturecomponentsandjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityMainBinding
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.databinding1.DataBindingActivity
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.databinding2.DataBindingAndViewModel
import com.wizion.androidarchitecturecomponentsandjetpack.lifecycle_aware_components.LifecycleAwareActivity
import com.wizion.androidarchitecturecomponentsandjetpack.livedata.LiveDataActivity
import com.wizion.androidarchitecturecomponentsandjetpack.database.room_database.RoomDatabaseActivity
import com.wizion.androidarchitecturecomponentsandjetpack.database.sql_database.SQLiteActivity
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.diff_util.DiffUtilActivity
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.MvvmRetrofitRoomActivity
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room.MvvmMainActivity
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.retrofit.RetrofitActivity
import com.wizion.androidarchitecturecomponentsandjetpack.viewmodel.basics.ViewModelActivity
import com.wizion.androidarchitecturecomponentsandjetpack.viewmodel.quotesapp.QuotesActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.btnMvvmRetrofitRoom.setOnClickListener {
            startActivity(Intent(this, MvvmRetrofitRoomActivity::class.java))
        }

        binding.btnRetrofit.setOnClickListener {
            startActivity(Intent(this, RetrofitActivity::class.java))
        }

        binding.btnDiffUtil.setOnClickListener {
            startActivity(Intent(this, DiffUtilActivity::class.java))
        }

        binding.btnmvvm.setOnClickListener {
            startActivity(Intent(this, MvvmMainActivity::class.java))
        }

        binding.btnRoom1.setOnClickListener{
            startActivity(Intent(this, RoomDatabaseActivity::class.java ))
        }

        binding.btnSQLite.setOnClickListener{
            startActivity(Intent(this, SQLiteActivity::class.java ))
        }

        binding.btnDataBinding2.setOnClickListener{
            startActivity(Intent(this, DataBindingAndViewModel::class.java ))
        }

        binding.btnDataBinding1.setOnClickListener{
            startActivity(Intent(this, DataBindingActivity::class.java ))
        }

        binding.btn2.setOnClickListener{
            startActivity(Intent(this,LiveDataActivity::class.java ))
        }
        binding.btn1.setOnClickListener{
            startActivity(Intent(this,QuotesActivity::class.java ))
        }

         binding.btnViewModel.setOnClickListener{
            startActivity(Intent(this, ViewModelActivity::class.java ))
        }


        binding.btnObserver.setOnClickListener {
            startActivity(Intent(this,LifecycleAwareActivity::class.java))
        }

    }
}