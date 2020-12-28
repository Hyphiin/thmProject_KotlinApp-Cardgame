package com.example.cardsagainstyourliver

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profilesettings.*

class ProfileSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilesettings)

        val context= this

        var spieler1 =PlayerClass("tester", 2, 2, 23,1,2,3,4,45  )
        var db= DBHandler(context)
        db.insertData(spieler1)

    }

    fun onClickBackToProfileButton(view: View) {

        val BackToProfileButton = Intent(this, ProfileActivity::class.java)
        startActivity(BackToProfileButton)
    }


    fun onClickBackToMenuButton(view: View) {
        val BackToMenuButton = Intent(this, MainActivity::class.java)
        Log.d("test",edit_age.text.toString())
        startActivity(BackToMenuButton)
    }
}