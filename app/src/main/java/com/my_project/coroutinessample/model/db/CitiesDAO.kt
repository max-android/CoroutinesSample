package com.my_project.coroutinessample.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.my_project.coroutinessample.model.entities.Town

@Dao
interface CitiesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(towns: List<Town>)

    @Query("SELECT COUNT(*) FROM town")
    fun sizeDB(): Int

    @Query("SELECT * FROM town")
    fun allData(): List<Town>
}