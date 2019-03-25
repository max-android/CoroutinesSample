package com.my_project.coroutinessample.di

import com.my_project.coroutinessample.presentation.presenter.FirstSamplePresenter
import com.my_project.coroutinessample.presentation.presenter.SecondSamplePresenter
import com.my_project.coroutinessample.ui.FirstFragment
import com.my_project.coroutinessample.ui.MainActivity
import com.my_project.coroutinessample.ui.SecondFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        ServiceModule::class,
        DatabaseModule::class,
        RouterModule::class,
        PresenterModule::class
    ]
)

interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
    fun injectFirstFragment(firstFragment: FirstFragment)
    fun injectSecondFragment(secondFragment: SecondFragment)
    fun injectFirstSamplePresenter(fPresenter: FirstSamplePresenter)
    fun injectSecondSamplePresenter(sPresenter: SecondSamplePresenter)
}