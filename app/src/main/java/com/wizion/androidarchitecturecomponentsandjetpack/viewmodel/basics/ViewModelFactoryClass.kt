package com.wizion.androidarchitecturecomponentsandjetpack.viewmodel.basics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


@Suppress("UNCHECKED_CAST")
class ViewModelFactoryClass(private val counter : Int) : ViewModelProvider.Factory {

    /*
        What is ViewModelFactory?

       The ViewModelFactory is responsible for creating the ViewModel object with any necessary dependencies. For example, if a ViewModel needs to access a database or network service, the ViewModelFactory can provide an instance of the required object to the ViewModel.
     */

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelClass(counter) as T
    }
}