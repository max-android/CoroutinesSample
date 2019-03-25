package com.my_project.coroutinessample.presentation.view

import com.my_project.coroutinessample.model.entities.Town


interface FirstView {
    fun showTowns(list: List<Town>)
    fun showError(error:String)
    fun showProgress()
}