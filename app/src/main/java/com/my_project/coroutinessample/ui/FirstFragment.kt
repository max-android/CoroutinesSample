package com.my_project.coroutinessample.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.my_project.coroutinessample.App
import com.my_project.coroutinessample.R
import com.my_project.coroutinessample.model.entities.Town
import com.my_project.coroutinessample.presentation.presenter.FirstSamplePresenter
import com.my_project.coroutinessample.presentation.view.FirstView
import com.my_project.coroutinessample.ui.common.Coord
import com.my_project.coroutinessample.ui.common.TownAdapter
import kotlinx.android.synthetic.main.first_fragment.*
import javax.inject.Inject


class FirstFragment : Fragment(), FirstView {

    @Inject
    lateinit var presenter: FirstSamplePresenter
    private lateinit var townAdapter: TownAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        App.appComponent.injectFirstFragment(this)
        super.onActivityCreated(savedInstanceState)
        presenter.bindView(this)
        initViews()
        citiesFromDB()
        showTownsButton.setOnClickListener { if (savedInstanceState == null) citiesFromApi() }
        startSecondSampleButton.setOnClickListener { launchSecondSample() }
    }

    override fun onDestroy() {
        presenter.cancelJob()
        presenter.unbindView()
        super.onDestroy()
    }

    override fun showTowns(list: List<Town>) {
        firstProgressBar.visibility = View.GONE
        townAdapter.clearData()
        townAdapter.setData(list)
    }

    override fun showError(error: String) {
        firstProgressBar.visibility = View.GONE
        Toast.makeText(context, "Error:$error", Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        firstProgressBar.visibility = View.VISIBLE
    }

    private fun initViews() {
        townAdapter = TownAdapter { Toast.makeText(context, "select:" + it.city, Toast.LENGTH_LONG).show() }
        townsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@FirstFragment.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@FirstFragment.context, LinearLayout.VERTICAL))
            adapter = townAdapter
        }
    }

    private fun launchSecondSample() {
        (activity as MainActivity).showSecondSample()
    }

    private fun citiesFromApi() {
        presenter.getCitiesFromApi(Coord.LAT, Coord.LON)
    }

    private fun citiesFromDB() {
        presenter.getCitiesFromDB()
    }
}