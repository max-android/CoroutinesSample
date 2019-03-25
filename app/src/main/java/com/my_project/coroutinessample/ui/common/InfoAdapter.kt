package com.my_project.coroutinessample.ui.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.coroutinessample.R
import com.my_project.coroutinessample.model.entities.Info
import kotlinx.android.synthetic.main.item_info.view.*


class InfoAdapter: RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    private var items: MutableList<Info> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = items[position]
        holder.bindTo(info)
    }

    override fun getItemCount() = items.size

    fun setData(info:List<Info>){
        items.addAll(info)
    }

    inner class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {
        fun bindTo(info: Info) {
            containerView.nameTextView.text = info.name
            containerView.carTextView.text = info.marka
        }
    }
}