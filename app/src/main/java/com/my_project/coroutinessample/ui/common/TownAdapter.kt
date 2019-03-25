package com.my_project.coroutinessample.ui.common


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my_project.coroutinessample.R
import com.my_project.coroutinessample.model.entities.Town
import kotlinx.android.synthetic.main.item_town.view.*


class TownAdapter(private val action:(Town)->Unit) : RecyclerView.Adapter<TownAdapter.ViewHolder>() {

   private var items: MutableList<Town> =  mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_town, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val town = items[position]
        holder.bindTo(town)
    }

    override fun getItemCount() = items.size

    fun setData(towns:List<Town>){
        items.addAll(towns)
    }

    fun clearData(){
        items.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        private lateinit var cTown: Town

        init {
            containerView.setOnClickListener { launchDetail() }
        }

        private fun launchDetail() {
            action(cTown)
        }
         fun bindTo(town: Town) = with(town){
            cTown = this
            containerView.townTextView.text = city
            containerView.countryTextView.text = country
        }
    }

}
