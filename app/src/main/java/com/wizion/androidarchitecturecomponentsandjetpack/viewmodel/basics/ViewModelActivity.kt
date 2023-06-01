package com.wizion.androidarchitecturecomponentsandjetpack.viewmodel.basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelBinding
    lateinit var mainViewModel : ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this, ViewModelFactoryClass(10))[ViewModelClass::class.java]
        setText()

        binding.btnIncrement.setOnClickListener {
            mainViewModel.increment()
            setText()
        }

    }

    private fun setText() {
        binding.txtCounter.text = mainViewModel.count.toString()
    }
}