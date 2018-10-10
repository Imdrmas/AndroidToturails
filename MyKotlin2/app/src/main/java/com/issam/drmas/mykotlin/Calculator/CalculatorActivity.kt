package com.issam.drmas.mykotlin.Calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.issam.drmas.mykotlin.R
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    var isNewOP = true
    fun buNumberEvent(view: View){

        if (isNewOP){
            txtViewShowNumber.text=""
        }
        isNewOP=false

        var txtViewNumber:String = txtViewShowNumber.text.toString()
        val buSelect = view as Button

        when(buSelect.id){
            buZero.id->{
                txtViewNumber+="0"
            }
            buOne.id->{
                txtViewNumber+="1"
            }
            buTwo.id->{
                txtViewNumber+="2"
            }
            buTree.id->{
                txtViewNumber+="3"
            }
            buFour.id->{
                txtViewNumber+="4"
            }
            buFive.id->{
                txtViewNumber+="5"
            }
            buSex.id->{
                txtViewNumber+="6"
            }
            buSeven.id->{
                txtViewNumber+="7"
            }
            buEight.id->{
                txtViewNumber+="8"
            }
            buNine.id->{
                txtViewNumber+="9"
            }
            buDot.id->{
                txtViewNumber+="."
            }
            buPDM.id->{
                txtViewNumber= "-" +txtViewNumber
            }
        }
        txtViewShowNumber.text = txtViewNumber
    }

    var oldNumber = ""
    var  op = "+"
    fun buOpEvent(view: View){

        oldNumber= txtViewShowNumber.text.toString()
        isNewOP = true
        val buSelect = view as Button

        when(buSelect.id){
            buDiv.id->{
                op = "/"
            }
            buMiltip.id->{
                op = "*"
            }
            buMinus.id->{
                op = "-"
            }
            buPlus.id->{
                op = "+"
            }
        }

    }

    fun buEqaulEvent(view: View){
        val newNumber = txtViewShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
           "/"->{
               finalNumber = oldNumber.toDouble() / newNumber.toDouble()
           }
            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        txtViewShowNumber.text = finalNumber.toString()
        isNewOP = true
    }

    fun buClear(view: View){
        isNewOP=true
        txtViewShowNumber.text="0"
    }
}
