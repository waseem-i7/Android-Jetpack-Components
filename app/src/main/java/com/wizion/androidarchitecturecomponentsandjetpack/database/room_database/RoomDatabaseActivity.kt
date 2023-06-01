package com.wizion.androidarchitecturecomponentsandjetpack.database.room_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivityRoomDatabaseBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class RoomDatabaseActivity : AppCompatActivity() {

    lateinit var database : ContactDatabase
    lateinit var binding : ActivityRoomDatabaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_room_database)
        /**
         * Room Database
         * ->Abstraction over SQLite
         * ->Less Boilerplate
         * ->Compile Time Verification of SQL Queries
         *
         * @Important
         * ->Entities(Tables)
         * ->DAO(Data Access Objects)
         * ->Database
         * ->Type Convertors
         * ->Migrations
         *
         * 1.Entity: An entity represents a table in the database. It is a Java or Kotlin class annotated with @Entity that defines the schema of the table.
         * 2.DAO (Data Access Object): The DAO is an interface annotated with @Dao that defines the database operations you can perform. It provides methods for inserting, updating, deleting, and querying the data stored in the database. You write these methods using annotations such as @Insert, @Update, @Delete, and @Query.
         * 3.Database: The database class is an abstract class annotated with @Database that serves as the main access point to the underlying SQLite database. It defines the entities and their relationships, and provides methods to obtain DAO instances. The database class is responsible for creating and managing the database.
         * 4.Type Convertors : SQLite only supports these 5 data-type
         * ->NULL
         * ->INTEGER
         * ->REAL
         * ->TEXT
         * ->BLOB
         * 5.Migration : Database migration is the process of modifying the database schema (structure) to accommodate changes in your application's data model while preserving existing data.
         *  #CREATE DB VERSION2#<---YES<---FIRST TIME USER?--->NO--->HAS DB VERSION1--->MIGRATE FROM 1TO2
         */



        database = ContactDatabase.getDatabase(this)
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Waseem","+916395604798", Date(),0))
        }

        binding.btnGetData.setOnClickListener {
            database.contactDao().getContact().observe(this){
                Log.d("CodeWithWaseem",it.toString())
            }
        }


    }
}