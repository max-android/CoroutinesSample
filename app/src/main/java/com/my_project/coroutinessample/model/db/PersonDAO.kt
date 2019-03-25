package com.my_project.coroutinessample.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.my_project.coroutinessample.model.entities.Person

@Dao
interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(persons: List<Person>)

    @Query("SELECT * FROM person")
    fun allData(): List<Person>
}