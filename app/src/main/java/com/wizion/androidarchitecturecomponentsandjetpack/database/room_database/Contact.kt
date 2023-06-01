package com.wizion.androidarchitecturecomponentsandjetpack.database.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.IdentityHashMap

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val phone : String,
    val createdDate: Date,
    val isActive : Int
)
