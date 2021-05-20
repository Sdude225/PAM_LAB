package com.sample.app.feed.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R

class HorizontalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemList: List<String>? = null
    private var indexRow = -1
    fun setData(data: List<String>) {
        if (itemList !== data) {
            itemList = data
            notifyDataSetChanged()
        }
    }

    fun setRowIndex(index: Int) {
        indexRow = index
    }

    private inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView

        init {
            text = itemView.findViewById(R.id.item_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context: Context = parent.context
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.horizontal_list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(rawHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = rawHolder as ItemViewHolder
        holder.text.text = itemList!![position]
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return itemList!!.size
    }
}