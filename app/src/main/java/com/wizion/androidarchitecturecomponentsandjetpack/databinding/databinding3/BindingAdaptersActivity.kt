package com.wizion.androidarchitecturecomponentsandjetpack.databinding.databinding3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityBindingAdaptersBinding

class BindingAdaptersActivity : AppCompatActivity() {
    lateinit var binding : ActivityBindingAdaptersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_adapters)

        val post = Post(
            "Introduction To Kotlin",
            "CodeWithWaseem",
            "https://tse3.mm.bing.net/th?id=OIP.PH-oORBPM0Oyi8v5o9PbhwHaEK&pid=Api&P=0"
        )
        binding.post = post
    }
}