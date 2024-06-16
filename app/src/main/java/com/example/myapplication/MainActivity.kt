package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.calculateButton.setOnClickListener {
            calculateBMI()
        }

    }

    private fun calculateBMI() {
        val heightStr = binding.heightEditText.text.toString()
        val weightStr = binding.weightEditText.text.toString()


        if (TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(weightStr)) {
            binding.resultTextView.text = "Please enter valid height and weight"
            return
        }

        val height = heightStr.toFloatOrNull()
        val weight = weightStr.toFloatOrNull()

        if (height == null || weight == null || height <= 0 || weight <= 0) {
            binding.resultTextView.text = "Please enter positive number"
            return
        }

        val bmi = weight / (height * height)
        binding.resultTextView.text = String.format("You BMI is: %.2f", bmi)
    }


}