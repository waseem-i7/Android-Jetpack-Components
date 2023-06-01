package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.api.QuoteService
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.repository.QuotesRepository
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.repository.Response
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.viewmodels.MainViewModel
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.viewmodels.MainViewModelFactory
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.retrofit.RetrofitHelper

class MvvmRetrofitRoomActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_retrofit)

        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this) {
            when(it){
                is Response.Loading -> {}
                is Response.Success -> {
                    it.data?.let {it1->
                        Toast.makeText(this, it1.results.size.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
                is Response.Error -> {
                    Toast.makeText(this, it.errorMessage.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}