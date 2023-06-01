package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String,
    val author : String
)