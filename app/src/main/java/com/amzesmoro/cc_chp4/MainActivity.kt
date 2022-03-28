package com.amzesmoro.cc_chp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.amzesmoro.cc_chp4.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private var playMode: Int? = null
    private var player1Choice: Int? = null
    private var computerChoice: Int? = null
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        startGame()
        resetGame()
    }

    private fun startGame() {
        if (playMode == 0) {
            playerOneOnClick()
            computerOnClick()
        } else {
            playerOneOnClick()
        }
    }

    private fun playerOneOnClick() {
        var random: Int;
        mainBinding.ibRock.setOnClickListener {
            println("User klik batu...")
            player1Choice = 0
            setBgUserChoice(0)
            if (playMode != 0) {
                random = Random.nextInt(0,3)
                setBgComChoice(random)
                playGame(player1Choice, random)
            }
        }
        mainBinding.ibPaper.setOnClickListener {
            println("User klik kertas...")
            player1Choice = 1
            setBgUserChoice(1)
            if (playMode != 0) {
                random = Random.nextInt(0,3)
                setBgComChoice(random)
                playGame(player1Choice, random)
            }
        }
        mainBinding.ibScissor.setOnClickListener {
            println("User klik gunting...")
            player1Choice = 2
            setBgUserChoice(2)
            if (playMode != 0) {
                random = Random.nextInt(0,3)
                setBgComChoice(random)
                playGame(player1Choice, random)
            }
        }
    }

    private  fun computerOnClick() {
        mainBinding.ibRockCom.setOnClickListener {
            println("Komputer klik batu...")
            computerChoice = 0
            playGame(player1Choice, computerChoice)
        }
        mainBinding.ibPaperCom.setOnClickListener {
            println("Komputer klik kertas...")
            computerChoice = 1
            playGame(player1Choice, computerChoice)
        }
        mainBinding.ibScissorCom.setOnClickListener {
            println("Komputer klik guntung...")
            computerChoice = 2
            playGame(player1Choice, computerChoice)
        }
    }

    private fun setBgUserChoice(userChoice: Int) {
        when (PlayerShape.fromInt(userChoice)) {
            PlayerShape.ROCK -> {
                mainBinding.ibRock.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                mainBinding.ibPaper.setBackgroundColor(0)
                mainBinding.ibScissor.setBackgroundColor(0)
            }
            PlayerShape.PAPER -> {
                mainBinding.ibRock.setBackgroundColor(0)
                mainBinding.ibPaper.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                mainBinding.ibScissor.setBackgroundColor(0)
            }
            PlayerShape.SCISSOR -> {
                mainBinding.ibRock.setBackgroundColor(0)
                mainBinding.ibPaper.setBackgroundColor(0)
                mainBinding.ibScissor.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
            }
            else -> {
                mainBinding.ibRock.setBackgroundColor(0)
                mainBinding.ibPaper.setBackgroundColor(0)
                mainBinding.ibScissor.setBackgroundColor(0)
            }
        }
    }

    private fun setBgComChoice(comChoice: Int) {
        when (PlayerShape.fromInt(comChoice)) {
            PlayerShape.ROCK -> {
                mainBinding.ibRockCom.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                mainBinding.ibPaperCom.setBackgroundColor(0)
                mainBinding.ibScissorCom.setBackgroundColor(0)
            }
            PlayerShape.PAPER -> {
                mainBinding.ibRockCom.setBackgroundColor(0)
                mainBinding.ibPaperCom.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                mainBinding.ibScissorCom.setBackgroundColor(0)
            }
            PlayerShape.SCISSOR -> {
                mainBinding.ibRockCom.setBackgroundColor(0)
                mainBinding.ibPaperCom.setBackgroundColor(0)
                mainBinding.ibScissorCom.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
            }
            else -> {
                mainBinding.ibRockCom.setBackgroundColor(0)
                mainBinding.ibPaperCom.setBackgroundColor(0)
                mainBinding.ibScissorCom.setBackgroundColor(0)
            }
        }
    }

    private fun playGame(playerChoice: Int?, computerChoice: Int?) {
        if (playerChoice != null) {
            when {
                (playerChoice.plus(1)).mod(3) == computerChoice -> {
                    Log.d(TAG, "Komputer menang!!")
                    mainBinding.tvResult.setText("Komputer\nMenang!!")
                }
                playerChoice == computerChoice -> {
                    Log.d(TAG, "Seri!!")
                    mainBinding.tvResult.setText("Seri!!")
                }
                else -> {
                    Log.d(TAG, "Player 1 menang!!")
                    mainBinding.tvResult.setText("Pemain 1\nMenang!!")
                }
            }
        }
    }

    private fun resetGame() {
        mainBinding.apply {
            setBgUserChoice(-1)
            setBgComChoice(-1)
            player1Choice = null
            computerChoice = null
            btnReset.setOnClickListener {
                Log.d(TAG, "RESET GAME!!")
                ibRock.setBackgroundColor(0)
                ibRockCom.setBackgroundColor(0)
                ibScissor.setBackgroundColor(0)
                ibScissorCom.setBackgroundColor(0)
                ibPaper.setBackgroundColor(0)
                ibPaperCom.setBackgroundColor(0)
                tvResult.setText("VERSUS")
            }
        }
    }

}