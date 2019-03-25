package com.my_project.coroutinessample.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "town")
data class Town(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("localized_country_name") @Expose val country:String,
    @SerializedName("city") @Expose val city:String,
    @SerializedName("lon") @Expose val lon:Double,
    @SerializedName("lat") @Expose val lat:Double)





