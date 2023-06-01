package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.repository.QuotesRepository

class MainViewModelFactory(private val repository: QuotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}