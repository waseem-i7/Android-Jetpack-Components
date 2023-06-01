package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room

import androidx.lifecycle.LiveData
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room.Quote
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room.QuoteDao

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes() : LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}