package com.example.androidessentials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNumber: EditText
    private lateinit var btnSendNumber: Button
    //private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        btnSendNumber = findViewById(R.id.btnSendNumber)
        //txtResult = findViewById(R.id.txtResult)

        btnSendNumber.setOnClickListener {
            val number = editTextNumber.text.toString().toInt()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NUMBER", number)
            startActivity(intent)
        }
    }
}