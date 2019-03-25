package com.my_project.coroutinessample.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.my_project.coroutinessample.model.entities.Car


@Dao
interface CarDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(towns: List<Car>)

    @Query("SELECT * FROM car")
    fun allData(): List<Car>
}