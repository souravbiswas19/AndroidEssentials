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

        btnMultiplyAndReturn.setOnClickListener {
            val result = receivedNumber * 2
            val returnIntent = Intent()
            returnIntent.putExtra("RESULT", result)

            // Set the result using setResult with the Intent
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }

}