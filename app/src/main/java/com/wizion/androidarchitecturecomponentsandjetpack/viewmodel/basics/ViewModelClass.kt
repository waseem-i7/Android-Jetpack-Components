package com.wizion.androidarchitecturecomponentsandjetpack.viewmodel.basics

import androidx.lifecycle.ViewModel

class ViewModelClass(initialValue : Int) : ViewModel() {

    /*
    What is ViewModel?
    ViewModel is a class that helps you store and manage UI-related data in a way that is independent of the UI components and survives configuration changes.
    *Model for your views such as Activity or Fragment.
    *View Models are lifecycle aware.
    *Data required for your screen is stored at one place i.e ViewModel. It may involve
    formatting that data in a particular format, accumulating data, any logic in displaying this data in your UI.

    ******Important******
    The ViewModel is only cleared when the Activity or Fragment finishes. If the screen is rotated and the Activity is recreated, then the ViewModel retain.

*/


    var count : Int = initialValue

    fun increment() {
        count++
    }

}