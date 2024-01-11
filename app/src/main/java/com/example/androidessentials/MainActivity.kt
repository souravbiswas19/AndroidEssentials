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

    //Declaring Send Button, EditText for Input and Text View for return result of First Activity
    private lateinit var editTextNumber: EditText
    private lateinit var btnSendNumber: Button
    private lateinit var txtResult: TextView
    @SuppressLint("SetTextI18n")
    // Registering for the result of an activity using the ActivityResultContracts.StartActivityForResult.
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) // Checking if the result code indicates a successful operation.
            {
                val data: Intent? = result.data // Extracting data from the returned Intent
                val resultValue = data?.getIntExtra("RESULT", 0) // Extracting the result value from the Intent, defaulting to 0 if not present
                txtResult.text = "Result after multiplying 2 : $resultValue"  // Updating the UI to display the result after multiplying 2
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing UI components
        editTextNumber = findViewById(R.id.editTextNumber)
        btnSendNumber = findViewById(R.id.btnSendNumber)
        txtResult = findViewById(R.id.txtResult)

        // Setting ClickListener for the "Send Number" button
        btnSendNumber.setOnClickListener {
            val number = editTextNumber.text.toString().toIntOrNull() // Extracting the number from the editText and converting it to Int

            if (number != null) {
                val intent = Intent(this, SecondActivity::class.java) // Creating an Intent to start the SecondActivity and passing the number as an extra
                intent.putExtra("NUMBER", number)

                // Start the SecondActivity for result using the ActivityResultLauncher
                startForResult.launch(intent)
            } else {
                // Handling the case where the input is not a valid number
                editTextNumber.error = "Please enter a valid number"
            }
        }
    }
}