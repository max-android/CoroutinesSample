package com.my_project.coroutinessample.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "car")
data class Car(@PrimaryKey(autoGenerate = true) val id: Int,
                val marka:String,
                val color:String,
                val value:Double)
