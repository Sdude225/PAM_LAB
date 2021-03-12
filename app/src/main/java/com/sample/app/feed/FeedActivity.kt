package com.sample.app.feed

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.feed.adapters.VerticalAdapter

class FeedActivity : AppCompatActivity() {
    var itemList: MutableList<List<String>>? = null
    private var verticalList: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        prepareData()
        initListView()
    }

    private fun prepareData() {
        itemList = ArrayList()
        val vItemCount = 5
        val hItemCount = 10
        for (i in 0 until vItemCount) {
            val hList: MutableList<String> = ArrayList()
            for (j in 0 until hItemCount) {
                hList.add("Item.$j")
            }
            (itemList as ArrayList<List<String>>).add(hList)
        }
    }

    private fun initListView() {
        verticalList = findViewById<View>(R.id.vertical_list) as RecyclerView
        verticalList!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val verticalAdapter = VerticalAdapter()
        verticalAdapter.setData(itemList)
        verticalList!!.adapter = verticalAdapter
    }
}