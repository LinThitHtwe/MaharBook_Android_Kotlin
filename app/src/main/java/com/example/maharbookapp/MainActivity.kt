package com.example.maharbookapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.Map

class MainActivity : AppCompatActivity() {

    private lateinit var tvDate: TextView
    private lateinit var btnDatePicker: Button
    private lateinit var comboBox : Spinner
    private lateinit var answerTV : TextView
    private lateinit var submitBtn : Button
    private lateinit var resetBtn : Button
    private lateinit var zodiacTV : TextView

    val days = arrayOf("Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Yar Hu")
    //private val days = HashMap<Int, String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDate = findViewById(R.id.tvDate)
        btnDatePicker = findViewById(R.id.btnDatePicker)
        answerTV = findViewById(R.id.answerTV)
        zodiacTV = findViewById(R.id.zodiacTV)

        val myCalender = Calendar.getInstance()
        val datepicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            puttingYarTeAlong(myCalender)
            zodiacFindingFun(myCalender)
        }
        btnDatePicker.setOnClickListener(){
            DatePickerDialog(this, datepicker, myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),
                myCalender.get(Calendar.DAY_OF_MONTH)).show()

        }

    }
    private fun zodiacFindingFun(myCalender: Calendar){

        if(myCalender.get(Calendar.MONTH)==0){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<20){
                zodiacTV.text="Capricorn"
            }
            else{
                zodiacTV.text="Aquarius"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==1){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<19){
                zodiacTV.text="Aquarius"
            }
            else{
                zodiacTV.text="Pisces"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==2){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<21){
                zodiacTV.text="Pisces"
            }
            else{
                zodiacTV.text="Aries"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==3){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<20){
                zodiacTV.text="Aries"
            }
            else{
                zodiacTV.text="Taurus"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==4){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<21){
                zodiacTV.text="Taurus"
            }
            else{
                zodiacTV.text="Gemini"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==5){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<23){
                zodiacTV.text="Gemini"
            }
            else{
                zodiacTV.text="Cancer"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==6){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<23){
                zodiacTV.text="Cancer"
            }
            else{
                zodiacTV.text="Leo"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==7){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<23){
                zodiacTV.text="Leo"
            }
            else{
                zodiacTV.text="Virgo"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==8){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<23){
                zodiacTV.text="Virgo"
            }
            else{
                zodiacTV.text="Libra"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==9){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<23){
                zodiacTV.text="Libra"
            }
            else{
                zodiacTV.text="Scorpio"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==10){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<22){
                zodiacTV.text="Scorpio"
            }
            else{
                zodiacTV.text="Sagittarius"
            }
        }
        else if(myCalender.get(Calendar.MONTH)==11){
            if(myCalender.get(Calendar.DAY_OF_MONTH)<22){
                zodiacTV.text="Sagittarius"
            }
            else{
                zodiacTV.text="Capricorn"
            }
        }
        var testzodiac = zodiacTV.text.toString()
        Log.d("ZODIACVAL","Eng Zodiac ${myCalender.get(Calendar.MONTH)} ${myCalender.get(Calendar.DAY_OF_MONTH)} ${testzodiac}")
    }

    private fun changingToBurmeseYear(myCalender: Calendar ):Int {
        var burmeseYear: Int
        if(myCalender.get(Calendar.MONTH)<4 && myCalender.get(Calendar.DAY_OF_MONTH)<17){
            burmeseYear= myCalender.get(Calendar.YEAR)-639
            Log.d("CHECKVALUE","Eng Year ${myCalender.get(Calendar.MONTH)} ")

        }

        else{
            burmeseYear= myCalender.get(Calendar.YEAR)-638

        }
        Log.d("CHECKVALUE","burmeseYear = ${burmeseYear} ")
        return burmeseYear%7

    }

    private fun calculation(myCalender: Calendar): Int{
        var Birthday = myCalender.get(Calendar.DAY_OF_WEEK).mod(7)
        Log.d("DAYOFWEEK","day of week $Birthday")
        var result = ((5*Birthday)+(2*changingToBurmeseYear(myCalender)))%7
        return result
    }

    private fun puttingYarTeAlong(MyCalender: Calendar ){
        val answers = HashMap<Int, String>()
        val orderingMolVal = calculation(MyCalender)
        answers[0] = "Bin Ga"
        answers[1] = "Ma Ya Na"
        answers[2] = "A Htoon"
        answers[3] = "Thike"
        answers[4] = "Ya Za"
        answers[5] = "Pu Ti"
        answers[6] = "A Di Pa Di"


        answerTV.text=(answers.get(orderingMolVal))



    }
}