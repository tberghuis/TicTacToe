package com.tomberghuis.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View){
        val btnSelected= view as Button
        var cellId=0
//        when(btnSelected.id){
//            R.id.btn1-> cellId=1
//            R.id.btn2-> cellId=2
//            R.id.btn3-> cellId=3
//            R.id.btn4-> cellId=4
//            R.id.btn5-> cellId=5
//            R.id.btn6-> cellId=6
//            R.id.btn7-> cellId=7
//            R.id.btn8-> cellId=8
//            R.id.btn9-> cellId=9
//        }

        when(btnSelected){
            btn1-> cellId=1
            btn2-> cellId=2
            btn3-> cellId=3
            btn4-> cellId=4
            btn5-> cellId=5
            btn6-> cellId=6
            btn7-> cellId=7
            btn8-> cellId=8
            btn9-> cellId=9
        }

        //Toast.makeText(this,"ID:"+ cellId, Toast.LENGTH_LONG).show()
//
        PlayGame(cellId,btnSelected)
    }

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var ActivePlayer=1

    fun PlayGame(cellID:Int,buSelected:Button){

        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            ActivePlayer=2
            AutoPlay()
        }else{
            buSelected.text="O"
            buSelected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellID)
            ActivePlayer=1
        }


        buSelected.isEnabled=false
        CheckWiner()
    }



    fun  CheckWiner(){
        var winer=-1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer=2
        }


        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer=2
        }




        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer=2
        }


        if( winer != -1){

            if (winer==1){
                Toast.makeText(this," Player 1  win the game", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this," Player 2  win the game", Toast.LENGTH_LONG).show()

            }

        }

    }


    fun AutoPlay(){

        var emptyCells=ArrayList<Int>()
        for ( cellID in 1..9){

            if(!( player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }


        val r= Random()
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellID= emptyCells[randIndex]

        var btnSelect:Button?
        when(cellID){
            1-> btnSelect=btn1
            2-> btnSelect=btn2
            3-> btnSelect=btn3
            4-> btnSelect=btn4
            5-> btnSelect=btn5
            6-> btnSelect=btn6
            7-> btnSelect=btn7
            8-> btnSelect=btn8
            9-> btnSelect=btn9
            else->{
                btnSelect=btn1
            }
        }

        PlayGame(cellID,btnSelect)

    }
}
