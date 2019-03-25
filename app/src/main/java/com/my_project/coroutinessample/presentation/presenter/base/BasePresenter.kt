package com.my_project.coroutinessample.presentation.presenter.base


open class BasePresenter<T> {

    var view: T? = null

    fun bindView(view: T) {
        this.view = view
    }

    fun unbindView() {
        this.view = null
    }

}