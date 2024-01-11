package com.example.androidessentials

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    //Declaring buttons and Text View of Second Activity
    private lateinit var txtReceivedNumber: TextView
    private lateinit var btnMultiplyAndReturn: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize UI components by finding their references in the layout folder
        txtReceivedNumber = findViewById(R.id.txtReceivedNumber)
        btnMultiplyAndReturn = findViewById(R.id.btnMultiplyAndReturn)

        // Extract the received number from the intent's extra with a default value of 0
        val receivedNumber = intent.getIntExtra("NUMBER", 0)
        txtReceivedNumber.text = "Received Number is : $receivedNumber" // Display the received number in the TextView

        // Set a click listener for the "Back" button
        btnMultiplyAndReturn.setOnClickListener {
            val result = receivedNumber * 2 // Calculate the result by multiplying the received number by 2
            val returnIntent = Intent() // Intent created to return the result to the calling activity
            returnIntent.putExtra("RESULT", result)
            setResult(RESULT_OK, returnIntent) // Set the result with RESULT_OK and the return Intent
            finish() // Finish the activity to return to the calling activity
        }
    }

}