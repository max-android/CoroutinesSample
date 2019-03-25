package com.my_project.coroutinessample.presentation.view

import com.my_project.coroutinessample.model.entities.Info


interface SecondView {
    fun showInfo(list: List<Info>)
    fun showError(error:String)
    fun showProgress()
}