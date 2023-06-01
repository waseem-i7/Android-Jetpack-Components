package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.api.QuoteService
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.db.QuoteDatabase
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.QuoteList
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.utils.NetworkUtils
import java.lang.Exception

class QuotesRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<Response<QuoteList>>()

    val quotes: LiveData<Response<QuoteList>>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int) {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            try {
                val result = quoteService.getQuotes(page)
                if (result?.body() != null) {
                    quoteDatabase.quoteDao().addQuotes(result.body()!!)
                    quotesLiveData.postValue(Response.Success(result.body()))
                }else{
                    quotesLiveData.postValue(Response.Error("API Error"))
                }
            }catch (e : Exception){
                quotesLiveData.postValue(Response.Error(e.message.toString()))
            }
        } else {
            try {
                val quotes = quoteDatabase.quoteDao().getQuotes()
                quotesLiveData.postValue(Response.Success(quotes))
            }catch (e : Exception){
                quotesLiveData.postValue(Response.Error(e.message.toString()))
            }
        }
    }

    suspend fun getQuotesBackground(){
        val randomNumber = (Math.random()*10).toInt()
        val result = quoteService.getQuotes(randomNumber)
        if (result?.body() != null){
            quoteDatabase.quoteDao().addQuotes(result.body()!!)
        }
    }
}