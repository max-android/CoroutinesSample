package com.my_project.coroutinessample.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val age: Int
)
