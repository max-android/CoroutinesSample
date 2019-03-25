package com.my_project.coroutinessample.di

import android.arch.persistence.room.Room
import android.content.Context
import com.my_project.coroutinessample.model.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "db_store").build()
    }
}