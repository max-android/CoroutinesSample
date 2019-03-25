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
import com.my_project.coroutinessample.model.entities.Info
import com.my_project.coroutinessample.presentation.presenter.SecondSamplePresenter
import com.my_project.coroutinessample.presentation.view.SecondView
import com.my_project.coroutinessample.ui.common.InfoAdapter
import kotlinx.android.synthetic.main.second_fragment.*
import javax.inject.Inject

class SecondFragment : Fragment(), SecondView {

    @Inject
    lateinit var presenter: SecondSamplePresenter
    private lateinit var infoAdapter: InfoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        App.appComponent.injectSecondFragment(this)
        super.onActivityCreated(savedInstanceState)
        presenter.bindView(this)
        initViews()
        requestInfo()
    }

    override fun onDestroy() {
        presenter.cancelJob()
        presenter.unbindView()
        super.onDestroy()
    }

    override fun showInfo(list: List<Info>) {
        secondProgressBar.visibility = View.GONE
        infoAdapter.setData(list)
    }

    override fun showError(error: String) {
        secondProgressBar.visibility = View.GONE
        Toast.makeText(context, "Error:$error", Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        secondProgressBar.visibility = View.VISIBLE
    }

    private fun initViews() {
        infoAdapter = InfoAdapter()
        infoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@SecondFragment.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@SecondFragment.context, LinearLayout.VERTICAL))
            adapter = infoAdapter
        }
    }

    private fun requestInfo() {
        presenter.getInfo()
    }
}