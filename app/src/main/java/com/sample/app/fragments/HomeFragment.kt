package com.sample.app.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.feed.adapters.VerticalAdapter
import com.sample.app.network.Connection
import com.sample.app.network.models.SearchResult
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var itemList: MutableList<List<String>>? = null
    private var verticalList: RecyclerView? = null
    private lateinit var  service: Connection
    private var queryResult : ArrayList<SearchResult>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareData()
        initListView()
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }


    private fun prepareData() {
        service = Connection()

        getSearchResult("""{ "keywords": "construction", "location": "", "radius": "", "salary": 500, "page": "1" }""")

        itemList = ArrayList()
        val vItemCount = 5
        val hItemCount = 20
        for (i in 0 until vItemCount) {
            val hList: MutableList<String> = ArrayList()
            for (j in 0 until hItemCount) {
                hList.add("Item.$j")
            }
            (itemList as ArrayList<List<String>>).add(hList)
        }
    }

    private fun getSearchResult(query : String) {
        GlobalScope.launch {
            kotlin.runCatching {
                service.search(query)
            }.onSuccess {
                handleData(it)
            }.onFailure {
                print("smerti")
            }
        }
    }

    private fun handleData(data : ArrayList<SearchResult>) {
        queryResult = data
    }

    private fun initListView() {
        verticalList = view?.findViewById(R.id.vertical_list) as RecyclerView
        verticalList!!.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        val verticalAdapter = VerticalAdapter()
        verticalAdapter.setData(itemList)
        verticalList!!.adapter = verticalAdapter
    }
}