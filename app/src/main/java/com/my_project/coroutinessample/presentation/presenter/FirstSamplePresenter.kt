package com.my_project.coroutinessample.presentation.presenter

import com.my_project.coroutinessample.App
import com.my_project.coroutinessample.model.repository.FirstSampleRepository
import com.my_project.coroutinessample.presentation.presenter.base.BasePresenter
import com.my_project.coroutinessample.presentation.view.FirstView
import kotlinx.coroutines.*
import javax.inject.Inject

class FirstSamplePresenter : BasePresenter<FirstView>() {

    @Inject
    lateinit var repository: FirstSampleRepository

    private var job = SupervisorJob()
    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        view?.showError(throwable.toString())
    }
    private val uiScope = CoroutineScope(Dispatchers.Main + job + exceptionHandler + CoroutineName("first-test"))

    init {
        App.appComponent.injectFirstSamplePresenter(this)
    }

    fun getCitiesFromApi(lat: String, lon: String) = uiScope.launch {
        view?.showProgress()
        val cities = withContext(Dispatchers.IO) {
            val apiList = repository.sendApiRequest(lat, lon)
            repository.writeDB(apiList)
            return@withContext apiList
        }
        view?.showTowns(cities)
    }

    fun getCitiesFromDB() = uiScope.launch {
        view?.showProgress()
        val cities = withContext(Dispatchers.IO) {
            // throw java.lang.Exception("opit exception")
            repository.sendDBRequest()
        }
        view?.showTowns(cities)
    }

    fun cancelJob() {
        uiScope.coroutineContext.cancelChildren()
    }
}