package com.drmas.issam.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.ArrayList

class Main2Activity : AppCompatActivity() {

    internal var Num = 0
    internal var myName = "drmas"
    internal var listNum = ArrayList<Integer>()

    companion object {
        var mName = "drmas"
        var mNum = 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if (getIntent().hasExtra("keyURL")){
            var url = getIntent().extras.getString("keyURL")
            webView.loadUrl(url)
        } else{
            webView.loadUrl("https://www.youtube.com")
        }



       var n = Num(2, 2)


    } //// End Main

    fun Num(num1:Int, num2:Int) :Int{
        var fnum = num1
        if (num1 > num2){
            fnum = num1 + 10
        }
        return num1 + num2
    }

    fun myName(word:String) :String{
        var txt = word
        var len = 0
        len = txt.length
        if (len > 2){
            txt = word.substring(2)
        }
        return txt
    }

} //// ending
