package com.wizion.androidarchitecturecomponentsandjetpack.databinding.databinding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityDataBindingAndViewModelBinding

class DataBindingAndViewModel : AppCompatActivity() {
    lateinit var binding: ActivityDataBindingAndViewModelBinding
    lateinit var mainViewModel: DataBindingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_and_view_model)
        mainViewModel = ViewModelProvider(this)[DataBindingViewModel::class.java]
        binding.dataBindingViewModel = mainViewModel
        //we have to add lifecycle owner to observe live data
        binding.lifecycleOwner = this
    }
}