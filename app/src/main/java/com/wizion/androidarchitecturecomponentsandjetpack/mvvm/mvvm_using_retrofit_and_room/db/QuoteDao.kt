package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.QuoteList
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.Result

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotes(quotes : QuoteList)

    @Query("SELECT * FROM quote LIMIT 1")
    suspend fun getQuotes() : QuoteList
}