package com.my_project.coroutinessample

import android.app.Application
import com.my_project.coroutinessample.di.*


class App: Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .repositoryModule(RepositoryModule())
            .serviceModule(ServiceModule())
            .databaseModule(DatabaseModule(this))
            .routerModule(RouterModule())
            .presenterModule(PresenterModule())
            .build()
    }
}