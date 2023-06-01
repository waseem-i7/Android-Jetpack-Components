package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityMvvmMainBinding

class MvvmMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMvvmMainBinding
    private lateinit var mvvmViewModel: MvvmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm_main)

        val dao = QuoteDatabase.getDatabase(this).quoteDao()
        val repository = QuoteRepository(dao)
        mvvmViewModel = ViewModelProvider(this, MvvmViewModelFactory(repository))[MvvmViewModel::class.java]

        mvvmViewModel.getQuotes().observe(this){
            binding.quotes = it.toString()
        }
        binding.btnAddQuote.setOnClickListener {
             val quote = Quote(0,"This is Testing","Testing")
             mvvmViewModel.insertQuote(quote)
        }
    }
}