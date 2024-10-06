package com.example.textcounter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextInput: EditText
    private lateinit var spinnerCountType: Spinner
    private lateinit var buttonCount: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextInput = findViewById(R.id.editTextInput)
        spinnerCountType = findViewById(R.id.spinnerCountType)
        buttonCount = findViewById(R.id.buttonCount)
        textViewResult = findViewById(R.id.textViewResult)

        // Set up the spinner
        val options = arrayOf(getString(R.string.count_words), getString(R.string.count_chars))
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountType.adapter = adapter

        // Set button click listener
        buttonCount.setOnClickListener {
            countText()
        }
    }

    private fun countText() {
        val inputText = editTextInput.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_input_warning), Toast.LENGTH_SHORT).show()
            return
        }

        val countType = spinnerCountType.selectedItem.toString()
        val counter = TextCounter()

        val result = if (countType == getString(R.string.count_words)) {
            counter.countWords(inputText)
        } else {
            counter.countCharacters(inputText)
        }

        textViewResult.text = "${getString(R.string.result_label)} $result"
    }
}
