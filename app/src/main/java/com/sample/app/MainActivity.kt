package com.sample.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sample.app.feed.FeedActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageText: TextView = findViewById(R.id.messageText)

        recyclerListExampleButton.setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }
    }
}
