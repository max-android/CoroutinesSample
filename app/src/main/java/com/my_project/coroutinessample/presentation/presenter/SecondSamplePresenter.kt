package com.my_project.coroutinessample.presentation.presenter

import com.my_project.coroutinessample.App
import com.my_project.coroutinessample.model.entities.Car
import com.my_project.coroutinessample.model.entities.Info
import com.my_project.coroutinessample.model.entities.Person
import com.my_project.coroutinessample.model.repository.SecondSampleRepository
import com.my_project.coroutinessample.presentation.presenter.base.BasePresenter
import com.my_project.coroutinessample.presentation.view.SecondView
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SecondSamplePresenter(
        private val mainJob:Job = SupervisorJob(),
        private val ioContext:CoroutineDispatcher = Dispatchers.IO,
        override val coroutineContext: CoroutineContext = Dispatchers.Main + mainJob):CoroutineScope,
    BasePresenter<SecondView>() {

    @Inject
    lateinit var repository: SecondSampleRepository

    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler{_,throwable->
       launch(coroutineContext) { view?.showError(throwable.toString()) }
    }

    init {
        App.appComponent.injectSecondSamplePresenter(this)
    }

    fun getInfo()= launch(coroutineContext + exceptionHandler) {
        view?.showProgress()
        val cars:Deferred<List<Car>> = async(ioContext) {
            //delay(7000)
            // throw java.lang.Exception("opit except")
            repository.sendCarDBRequest()
        }

        val persons:Deferred<List<Person>> = async(ioContext) {
            //delay(2000)
            // throw java.lang.Exception("opit except")
            repository.sendPersonDBRequest()
        }

        val result = cars.await().zip(persons.await()) {
                cars: Car, persons: Person -> Info(persons.name,cars.marka)
        }
        view?.showInfo(result)
    }

    fun cancelJob() {
        mainJob.cancelChildren()
    }
}