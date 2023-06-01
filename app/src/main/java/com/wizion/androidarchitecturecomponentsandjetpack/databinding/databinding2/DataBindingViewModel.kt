package com.wizion.androidarchitecturecomponentsandjetpack.databinding.databinding2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingViewModel : ViewModel() {

    val quoteLiveData = MutableLiveData("What you give is what you get")

    fun updateQuote(){
        quoteLiveData.value="You'll see it when you believe it."
    }
}