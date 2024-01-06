package com.example.androidessentials

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNumber: EditText
    private lateinit var btnSendNumber: Button
    private lateinit var txtResult: TextView
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val resultValue = data?.getIntExtra("RESULT", 0)
                txtResult.text = "Result: $resultValue"
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextNumber = findViewById(R.id.editTextNumber)
        btnSendNumber = findViewById(R.id.btnSendNumber)
        txtResult = findViewById(R.id.txtResult)

        btnSendNumber.setOnClickListener {
            val number = editTextNumber.text.toString().toIntOrNull()

            if (number != null) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("NUMBER", number)

                // Start the activity for result using the ActivityResultLauncher
                startForResult.launch(intent)
            } else {
                // Handle invalid input
                editTextNumber.error = "Please enter a valid number"
            }
        }
    }
}