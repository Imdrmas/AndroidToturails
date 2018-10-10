package com.issam.drmas.sharewishises.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.issam.drmas.sharewishises.MainActivity
import com.issam.drmas.sharewishises.R
import java.util.*

import java.util.Timer;
import java.util.TimerTask;

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer().schedule(object : TimerTask(){
            override fun run() {

                val intent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 1200)

    }
}

