package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MvvmViewModelFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmViewModel(quoteRepository) as T
    }
}