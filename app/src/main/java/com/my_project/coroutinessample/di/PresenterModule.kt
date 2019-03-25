package com.my_project.coroutinessample.di

import com.my_project.coroutinessample.presentation.presenter.FirstSamplePresenter
import com.my_project.coroutinessample.presentation.presenter.SecondSamplePresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideFirstSamplePresenter() = FirstSamplePresenter()

    @Provides
    @Singleton
    fun provideSecondSamplePresenter() = SecondSamplePresenter()
}