package com.wizion.androidarchitecturecomponentsandjetpack.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wizion.androidarchitecturecomponentsandjetpack.R

class LiveDataActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val factsTextView : TextView
    get() = findViewById(R.id.factsTextView)

    private val btnUpdate : Button
    get() = findViewById(R.id.btnUpdate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        /*
           What is LiveData?
            *LiveData is an observable data holder class that is part of the Android Architecture Components. LiveData is used to hold data that can be observed by UI components, such as Activities or Fragments.

            *MutableLiveData is a LiveData object that can be modified. This makes it useful for holding data that can change over time, such as user input or data from a network request.

            *The benefit of using LiveData (and MutableLiveData) is that it allows the UI to be updated automatically whenever the data changes. This means that you don't need to manually update the UI every time the data changes, which can save a lot of time and reduce bugs in your code.

         */

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.factsLiveData.observe(this, Observer {
            factsTextView.text = it
        })

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }

    }
}