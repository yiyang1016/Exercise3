package com.example.exercise3

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var radioGroup: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            Calc()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            Reset()
        }
    }

    private fun Calc() {
        //get Spinner
        //val age = findViewById<Spinner>(R.id.spinnerAge).selectedItemPosition
        val age1 = spinnerAge.selectedItemPosition
        var age2 = Age(age1)
        //get Radio Button Group
        var gender = Gender(age1)
        //get Checkbox
        var smoke = Smoker(age1)
        var total = age2 + gender + smoke
        val returnText  = findViewById<TextView>(R.id.textViewPremium)
        returnText.setText("Insurance Premium \n Total: RM " + total)
    }

    private fun Age(i: Int): Int {
        when (i) {
            0 -> return 60
            1 -> return 70
            2 -> return 90
            3 -> return 120

            else -> return 150
        }
    }

    private fun Gender(i: Int): Int {
        val gender = radioGroupGender
        if (gender == radioButtonMale) {
            when (i) {
                1 -> return 50
                2 -> return 100
                3 -> return 150

                else -> return 200
            }
        } else {
            return 0
        }
    }

    private fun Smoker(i: Int): Int {
        if (checkBoxSmoker.isChecked) {
            when (i) {
                1 -> return 100
                2 -> return 150
                3 -> return 200
                4 -> return 250

                else -> return 300
            }
        } else {
            return 0
        }
    }
    private fun Reset(){
        spinnerAge.setSelection(0)
        radioGroupGender.clearCheck()
        checkBoxSmoker.isChecked=false
        textViewPremium.text="Insurance Premium :"
    }
}
