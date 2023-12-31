package com.example.cardsagainstyourliver

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class PopUpEndRoundActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.end_round)

        val dm: DisplayMetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        var textGewinner = intent.getStringExtra("textWinner")
        val player1Name = intent.getStringExtra("player1name")
        val player2Name = intent.getStringExtra("player2name")
        val playerStart = intent.getStringExtra("playerStart")

        val textView: TextView = findViewById(R.id.player_name1)!!
        val textView2: TextView = findViewById(R.id.player_name2)!!
        val test1: ImageView = findViewById(R.id.test1)!!
        val textViewText: TextView = findViewById(R.id.result_text)!!

        val appSettingPrefs: SharedPreferences = getSharedPreferences("AppSettingPrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()
        val isNightModeOn: Boolean = appSettingPrefs.getBoolean("NightMode", false)

        if (isNightModeOn) {
            test1.setImageResource(R.drawable.pause2)
        } else {
            test1.setImageResource(R.drawable.pause)
        }

        var youHaveToDrink = getString(R.string.you_have_to_drink)
        var nobody = getString(R.string.nobody)
        if (isNightModeOn === false) {
            if (textGewinner == player1Name) {
                textView.setText(player1Name)
            } else if (textGewinner == player2Name) {
                textView.setText(player2Name)
            } else {
                textView.setText("$nobody")
            }
        } else if (isNightModeOn === true) {
            if (textGewinner == player1Name) {
                textView.setText(player2Name)
                textViewText.setText("$youHaveToDrink")
            } else if (textGewinner == player2Name) {
                textView.setText(player1Name)
                textViewText.setText("$youHaveToDrink")
            } else {
                textView.setText("$nobody")
                textViewText.setText("$youHaveToDrink")
            }
        }

        if (playerStart == player1Name) {
            textView2.setText(player2Name)
        } else {
            textView2.setText(player1Name)
        }

        window.setLayout(
            (width * 0.805).toInt(),
            (height * 0.805).toInt()
        )
    }

    fun nextRound(view: View) {
        val intent = Intent()
        setResult(RESULT_OK, intent)
        finish()
    }

}
