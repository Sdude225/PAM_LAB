package com.sample.app.feed.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R

class VerticalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemList: List<List<String>>? = null
    private val verticalTitlesNames = arrayOf("Painting", "IT", "Music", "Cooking", "Stroika")
    fun setData(data: List<List<String>>?) {1
        itemList = data
        notifyDataSetChanged()
    }

    private inner class HorizontalListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        private val horizontalList: RecyclerView
        val horizontalAdapter: HorizontalAdapter

        init {
            val context: Context = itemView.getContext()
            title = itemView.findViewById(R.id.item_title)
            horizontalList = itemView.findViewById(R.id.item_horizontal_list)
            horizontalList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            horizontalAdapter = HorizontalAdapter()
            horizontalList.adapter = horizontalAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context: Context = parent.context
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.vertical_list_item, parent, false)
        return HorizontalListViewHolder(itemView)
    }

    override fun onBindViewHolder(rawHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = rawHolder as HorizontalListViewHolder
        holder.title.text = verticalTitlesNames[position % verticalTitlesNames.size]
        holder.horizontalAdapter.setData(itemList!![position])
        holder.horizontalAdapter.setRowIndex(position)
    }

    override fun getItemCount(): Int {
        return itemList!!.size
    }
}