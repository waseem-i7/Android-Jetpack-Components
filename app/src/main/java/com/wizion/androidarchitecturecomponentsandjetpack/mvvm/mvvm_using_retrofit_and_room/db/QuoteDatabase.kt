package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wizion.androidarchitecturecomponentsandjetpack.database.room_database.Convertors
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.QuoteList
import com.wizion.androidarchitecturecomponentsandjetpack.mvvm.mvvm_using_retrofit_and_room.models.Result


@Database(entities = [QuoteList::class], version = 1)
@TypeConverters(QuoteConvertor::class)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDao

    companion object{
        @Volatile
        private var INSTANCE : QuoteDatabase? = null

        fun getDatabase(context : Context) : QuoteDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                    QuoteDatabase::class.java,
                    "quoteDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}