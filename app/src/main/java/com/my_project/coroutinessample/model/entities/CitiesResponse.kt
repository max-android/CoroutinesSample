package com.my_project.coroutinessample.model.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CitiesResponse(@SerializedName("results") @Expose val towns: List<Town>)


