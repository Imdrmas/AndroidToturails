package com.issam.drmas.mykotlin.TicTac

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.issam.drmas.mykotlin.R
import kotlinx.android.synthetic.main.activity_tic_tac.*
import java.util.*
import kotlin.math.log

class TicTacActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac)
    }

    fun butSelect(view: View){

        var butChoice = view as Button
        var celleId = 0

        when (butChoice.id){
            R.id.bu1-> celleId = 1;
            R.id.bu2-> celleId = 2;
            R.id.bu3-> celleId = 3;

            R.id.bu4-> celleId = 4;
            R.id.bu5-> celleId = 5;
            R.id.bu6-> celleId = 6;

            R.id.bu7-> celleId = 7;
            R.id.bu8-> celleId = 8;
            R.id.bu9-> celleId = 9;
        }

         Log.d("Celle ID: ", celleId.toString())
         playGame(celleId, butChoice)
         checkWinner()

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1;

    fun playGame(cellId:Int, buChoise:Button){

        if (activePlayer == 1){
            buChoise.text="X"
            buChoise.setBackgroundResource(R.color.colorPrimary)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()

        } else{
            buChoise.text="O"
            buChoise.setBackgroundResource(R.color.colorAccent)
            player2.add(cellId)
            activePlayer = 1
        }
        buChoise.isEnabled = false
    }

    fun checkWinner(){
        var winner =-1

        //Row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //Row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //Row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //Col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //Col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        //Col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if (winner!=-1){
            if (winner==1){
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun autoPlay(){

        val emptyCells=ArrayList<Int>()
        for (cellId in 1..9){
            if (!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val  CellId = emptyCells[randIndex]
        var buSelect:Button

        when(CellId){
            1->buSelect = bu1
            2->buSelect = bu2
            3->buSelect = bu3
            4->buSelect = bu4
            5->buSelect = bu5
            6->buSelect = bu6
            7->buSelect = bu7
            8->buSelect = bu8
            9->buSelect = bu9

            else->{
                buSelect = bu1
            }
        }
        playGame(CellId, buSelect)
    }

}
