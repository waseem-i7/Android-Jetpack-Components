package com.wizion.androidarchitecturecomponentsandjetpack.database.sql_database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "login.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery : String = "CREATE TABLE login_table (id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT)"
        db!!.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (newVersion>oldVersion){
            db!!.execSQL("DROP TABLE IF EXISTS login_table")
            onCreate(db)
        }
    }

    //Method to add login information to the database
    fun addLoginInfo(username : String,password : String){
        val db : SQLiteDatabase = this.writableDatabase
        val values : ContentValues = ContentValues()

        values.put("username",username)
        values.put("password",password)

        db.insert("login_table",null,values)
        db.close()
    }

    //Method to check if login information is valid
    fun checkLogin(username: String,password: String) : Boolean{
        val db : SQLiteDatabase = this.readableDatabase
        val columns : Array<String> = arrayOf("username")
        val selection : String = "username = ? AND password = ?"
        val selectionArgs : Array<String> = arrayOf(username,password)
        val cursor : Cursor = db.query("login_table",columns,selection,selectionArgs,null,null,null)
        val count = cursor.count
        cursor.close()
        db.close()
        return count > 0

    }


}