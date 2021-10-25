package com.example.wellcome.utils.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TripDao {
    @Insert
    fun insert(vararg trips: Trip)
    @Query("SELECT * FROM trip")
    fun getAll(): List<Trip>
}