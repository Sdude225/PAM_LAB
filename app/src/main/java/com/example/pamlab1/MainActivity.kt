package com.example.pamlab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText1)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            val text = editText.text.toString()
            intent.putExtra("data", text)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val editText: EditText = findViewById(R.id.editText1)
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                val data = data!!.getStringExtra("responseMessage")
                editText.setText(data)
            }
        }
    }
}