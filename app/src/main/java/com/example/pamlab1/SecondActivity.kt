package com.example.pamlab1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editText = findViewById<EditText>(R.id.editText2)
        val button = findViewById<Button>(R.id.button2)

        val data = intent.getStringExtra("data")
        editText.setText(data)

        button.setOnClickListener {
            val intent = Intent().apply {
                putExtra("responseMessage", editText.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}