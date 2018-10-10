package com.issam.drmas.mykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.issam.drmas.mykotlin.Calculator.CalculatorActivity
import com.issam.drmas.mykotlin.FindAge.FindAgeActivity
import com.issam.drmas.mykotlin.FoodApp.FoodActivity
import com.issam.drmas.mykotlin.TicTac.TicTacActivity
import java.time.Instant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun findAge(view:View){
       val intent = Intent(this, FindAgeActivity::class.java)
        startActivity(intent)
    }
    fun ticTac(view: View){
        val intent = Intent(this, TicTacActivity::class.java)
        startActivity(intent)
    }
    fun CalculatorClicked(view: View){
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
    fun FoodAppClicked(view: View){
        val intent = Intent(this, FoodActivity::class.java)
        startActivity(intent)
    }
}
