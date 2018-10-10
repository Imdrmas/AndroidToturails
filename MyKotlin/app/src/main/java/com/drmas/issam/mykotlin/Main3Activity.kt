package com.drmas.issam.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val row1_1 = arrayOf("drmas", "adel", "ihab", "kamal")
        val row2_1 = arrayOf("gmael", "amr", "tamer", "yaser")
        val row3_1 = arrayOf("omer", "issam", "ali", "amer")
        val table1 = arrayOf(row1_1, row2_1, row3_1)

        val row1_2 = arrayOf("drmas2", "adel2", "ihab2", "kamal2")
        val row2_2 = arrayOf("gmael2", "amr2", "tamer2", "yaser2")
        val row3_2 = arrayOf("omer2", "issam2", "ali2", "amer2")
        val table2 = arrayOf(row1_2, row2_2, row3_2)

        val row1_3 = arrayOf("drmas3", "adel3", "ihab3", "kamal3")
        val row2_3 = arrayOf("gmael3", "amr3", "tamer3", "yaser3")
        val row3_3 = arrayOf("omer3", "issam3", "ali3", "amer3")
        val table3 = arrayOf(row1_3, row2_3, row3_3)

        val allData = arrayOf(table1, table2, table3)

        for(table in allData){
            for (row in table){
                for (col in row){
                    
                }
                line.setText("------------------")
            }
        }



    }
}
