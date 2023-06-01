package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.db.QuoteConvertor

@Entity(tableName = "quote")
data class QuoteList(
    @PrimaryKey(autoGenerate = false)
    val quoteId : Int=1,
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    @ColumnInfo(name = "result_list")
    @TypeConverters(QuoteConvertor::class)
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)