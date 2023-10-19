package com.example.basic_spinner

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.basic_spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var genderType: ArrayList<Gender>

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        genderType = arrayListOf(
            Gender("Male", "남성"),
            Gender("Female", "여성"),
            Gender("Other", "기타")
        )

        val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, genderType)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.mySpinner.adapter = spinnerAdapter

        binding.mySpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedItem = parent?.getItemAtPosition(position) as Gender
                    binding.textGender.text = selectedItem.sex
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // empty here
                }
            }
    }
}