package com.my_project.coroutinessample.model.api

import com.my_project.coroutinessample.model.entities.CitiesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/2/cities")
    fun cities(@Query("lat") lat: String, @Query("lon") lon: String): Call<CitiesResponse>
}