package com.my_project.coroutinessample.model.repository


import com.my_project.coroutinessample.model.api.Api
import com.my_project.coroutinessample.model.db.AppDatabase
import com.my_project.coroutinessample.model.entities.Town
import javax.inject.Inject


class FirstSampleRepository @Inject constructor(private val api: Api, private val database: AppDatabase) {

    fun sendApiRequest(lat: String, lon: String): List<Town> {
        val response = api.cities(lat, lon).execute().body()
        return response?.towns ?: listOf()
    }

    fun sendDBRequest(): List<Town> {
        val response = database.citiesDAO().allData()
        return response
    }

    fun writeDB(towns: List<Town>) {
        database.citiesDAO().insertData(towns)
    }
}