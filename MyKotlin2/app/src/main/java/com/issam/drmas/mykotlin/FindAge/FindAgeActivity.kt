package com.issam.drmas.mykotlin.FindAge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.issam.drmas.mykotlin.R
import kotlinx.android.synthetic.main.activity_find_age.*
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class FindAgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_age)

        btnGetAge.setOnClickListener({
            val yearOfBirth = txtEnterAge.text.toString().toInt()
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val age = currentYear-yearOfBirth
            txtShowAge.text = "Your age is " + age + " years"
        })
    }
}
