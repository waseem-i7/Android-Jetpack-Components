package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.QuoteList
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.Result
import java.lang.reflect.Type

class QuoteConvertor {

    @TypeConverter
    fun fromList(value : List<Result>): String = Gson().toJson(value)

    @TypeConverter
    fun toList(value: String) : List<Result>{
        val listType : Type = object : TypeToken<List<Result>>(){}.type
        return Gson().fromJson(value,listType)
    }

}