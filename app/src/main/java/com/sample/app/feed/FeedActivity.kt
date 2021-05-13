package com.sample.app.feed

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sample.app.R
import com.sample.app.feed.adapters.VerticalAdapter
import com.sample.app.fragments.AccountFragment
import com.sample.app.fragments.CourseFragment
import com.sample.app.fragments.HomeFragment

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        var bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_nav)

        val homeFragment = HomeFragment()
        val courseFragment = CourseFragment()
        val accountFragment = AccountFragment()

        bottomNavigationView.setOnNavigationItemSelectedListener{item ->
            when (item.itemId) {
                R.id.home  -> {
                    setFragment(homeFragment)
                    true
                }
                R.id.courses -> {
                    setFragment(courseFragment)
                    true
                }
                R.id.account -> {
                    setFragment(accountFragment)
                    true
                }
            }
            false
        }
//        prepareData()
//        initListView()
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()

    }
}
