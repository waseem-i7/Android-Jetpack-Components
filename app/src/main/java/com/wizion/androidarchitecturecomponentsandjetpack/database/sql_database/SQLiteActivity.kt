package com.wizion.androidarchitecturecomponentsandjetpack.database.sql_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.wizion.androidarchitecturecomponentsandjetpack.R
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.ActivitySqliteBinding

class SQLiteActivity : AppCompatActivity() {
    lateinit var binding : ActivitySqliteBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sqlite)

        dbHelper = DatabaseHelper(this)

        //Example usage : adding login information
        dbHelper.addLoginInfo("example_user","example_password")


        //Example usage : checking login credentials
        val isValidLogin = dbHelper.checkLogin("example_user","example_password")

        if (isValidLogin){
            //Login successful, proceed to the next screen
            Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show()

        }else{
            //Invalid login, show an error message
            Toast.makeText(this,"Invalid login",Toast.LENGTH_SHORT).show()
        }








    }
}