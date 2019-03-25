package com.my_project.coroutinessample.di
import com.my_project.coroutinessample.model.api.Api
import com.my_project.coroutinessample.model.db.AppDatabase
import com.my_project.coroutinessample.model.repository.FirstSampleRepository
import com.my_project.coroutinessample.model.repository.SecondSampleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideFirstSampleRepository(api: Api,database: AppDatabase) =
        FirstSampleRepository(api,database)


    @Provides
    @Singleton
    fun provideSecondSampleRepository(database: AppDatabase) =
        SecondSampleRepository(database)

}