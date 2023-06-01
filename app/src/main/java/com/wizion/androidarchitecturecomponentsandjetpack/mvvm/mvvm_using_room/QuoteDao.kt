package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room.Quote

@Dao
interface QuoteDao {

    @Query("SELECT * from quote")
    fun getQuotes() : LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}