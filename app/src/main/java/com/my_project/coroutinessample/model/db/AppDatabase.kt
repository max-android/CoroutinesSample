package com.my_project.coroutinessample.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.my_project.coroutinessample.model.entities.Car
import com.my_project.coroutinessample.model.entities.Person
import com.my_project.coroutinessample.model.entities.Town

@Database(entities = [Town::class,Car::class,Person::class],  version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun citiesDAO(): CitiesDAO
    abstract fun carDAO(): CarDAO
    abstract fun personDAO(): PersonDAO
}