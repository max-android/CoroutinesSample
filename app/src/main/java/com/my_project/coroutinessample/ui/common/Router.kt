package com.my_project.coroutinessample.ui.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.my_project.coroutinessample.R
import com.my_project.coroutinessample.ui.FirstFragment
import com.my_project.coroutinessample.ui.SecondFragment


class Router {

    private lateinit var screen: String

    fun createFragment(fragmentManager: FragmentManager, screenKey: String) = when (screenKey) {

        Screens.FIRST_FRAGMENT -> {
            screen = Screens.FIRST_FRAGMENT
            showScreen(fragmentManager, FirstFragment(), false)
        }

        Screens.SECOND_FRAGMENT -> {
            screen = Screens.SECOND_FRAGMENT
            showScreen(fragmentManager, SecondFragment(), true)
        }

        else -> {
            throw Exception("unknown case")
        }
    }

    private fun showScreen(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean) {
        fragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .apply { if (addToBackStack) addToBackStack(null) }
            .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right)
            .commitAllowingStateLoss()
    }
}