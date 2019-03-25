package com.my_project.coroutinessample.di

import com.my_project.coroutinessample.ui.common.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RouterModule {

    @Provides
    @Singleton
    fun provideRouter() = Router()
}