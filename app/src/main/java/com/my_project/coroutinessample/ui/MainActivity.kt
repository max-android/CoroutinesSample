package com.my_project.coroutinessample.ui

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.my_project.coroutinessample.App
import com.my_project.coroutinessample.R
import com.my_project.coroutinessample.ui.common.Router
import com.my_project.coroutinessample.ui.common.Screens
import javax.inject.Inject

class MainActivity : AppCompatActivity(){

    @Inject lateinit var router: Router
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.injectMainActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) showFirstSample()
    }

   private fun showFirstSample(){
        router.createFragment(fragmentManager,Screens.FIRST_FRAGMENT)
    }

    fun showSecondSample(){
        router.createFragment(fragmentManager,Screens.SECOND_FRAGMENT)
    }
}
