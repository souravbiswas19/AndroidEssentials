package com.example.androidessentials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var txtReceivedNumber: TextView
    private lateinit var btnMultiplyAndReturn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txtReceivedNumber = findViewById(R.id.txtReceivedNumber)
        btnMultiplyAndReturn = findViewById(R.id.btnMultiplyAndReturn)

        val receivedNumber = intent.getIntExtra("NUMBER", 0)
        txtReceivedNumber.text = "Received Number: $receivedNumber"

    }
}