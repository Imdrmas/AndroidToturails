package com.drmas.issam.mykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast


var URL = ""
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast.setOnClickListener {
           // toast("that is Toast ")
            alert("this is Alert"){
                title("this an Alert")
                    positiveButton { toast("You clicked ok") }
                    negativeButton { toast("You clicked cancel") }
            }
        }

       btnAdd.setOnClickListener {
           val n1 = Integer.parseInt(eTxt1.text.toString())
           val n2 = Integer.parseInt(eTxt2.text.toString())
           val Result = n1+n2
           txtR.setText(""+Result)
           toast("Result: = $Result")
       }
        btnSub.setOnClickListener {
            val n1 = Integer.parseInt(eTxt1.text.toString())
            val n2 = Integer.parseInt(eTxt2.text.toString())
            val Result = n1-n2
            txtR.setText(""+Result)
            toast("Result: = $Result")
        }
        btnDiv.setOnClickListener {
            val n1 = Integer.parseInt(eTxt1.text.toString())
            val n2 = Integer.parseInt(eTxt2.text.toString())
            val Result = n1*n2
            txtR.setText(""+Result)
            toast("Result: = $Result")
        }
        btnModu.setOnClickListener {
            val n1 = Integer.parseInt(eTxt1.text.toString())
            val n2 = Integer.parseInt(eTxt2.text.toString())
            val Result = n1%n2
            txtR.setText(""+Result)
            toast("Result: = $Result")
        }

        ///////////////////////
        btnMain2.setOnClickListener {
            var intent = Intent(this, Main3Activity::class.java)
            intent.putExtra("keyURL", "https://www.google.com")
            startActivity(intent)
        }


    } /// end Main

    fun Num(num1:Int, num2:Int) :Int {
        return num1 + num2
    }


}//// Ending
