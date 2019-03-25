package com.my_project.coroutinessample.model.repository

import com.my_project.coroutinessample.model.db.AppDatabase
import com.my_project.coroutinessample.model.entities.Car
import com.my_project.coroutinessample.model.entities.Person
import javax.inject.Inject


class SecondSampleRepository @Inject constructor(private val database: AppDatabase) {

    fun sendCarDBRequest():List<Car>{
        writeCarDB(listOf(
            Car(1,"марка-1","синий",3.0),
            Car(2,"марка-2","белый",2.0),
            Car(3,"марка-3","черный",4.0),
            Car(4,"марка-4","красный",2.5),
            Car(5,"марка-5","серый",1.5),
            Car(6,"марка-6","оранжевый",5.0)
            ))
        val response = database.carDAO().allData()
        return response
    }

   private fun writeCarDB(cars:List<Car>){
        database.carDAO().insertData(cars)
    }

    fun sendPersonDBRequest():List<Person>{
        writePersonDB(listOf(
            Person(1,"имя-1",25),
            Person(2,"имя-2",28),
            Person(3,"имя-3",21),
            Person(4,"имя-4",18),
            Person(5,"имя-5",34),
            Person(6,"имя-6",32)

        ))
        val response = database.personDAO().allData()
        return response
    }

    private fun writePersonDB(persons:List<Person>){
        database.personDAO().insertData(persons)
    }
}