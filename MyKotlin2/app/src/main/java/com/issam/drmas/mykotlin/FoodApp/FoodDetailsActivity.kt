package com.issam.drmas.mykotlin.FoodApp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.issam.drmas.mykotlin.R
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val bundle = intent.extras
        val name = bundle.getString("name" )
        val des = bundle.getString("des")
        val image = bundle.getInt("iamge")

        imgDetails.setImageResource(image)
        nameDetails.text = name
        desDetails.text = des
    }
}
