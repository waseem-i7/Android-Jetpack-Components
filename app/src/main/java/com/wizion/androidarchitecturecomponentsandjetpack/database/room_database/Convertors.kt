package com.wizion.androidarchitecturecomponentsandjetpack.database.room_database

import androidx.room.TypeConverter
import java.util.Date

class Convertors {

    @TypeConverter
    fun fromDateToLong(value : Date) : Long{
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value : Long) : Date{
        return Date(value)
    }

}