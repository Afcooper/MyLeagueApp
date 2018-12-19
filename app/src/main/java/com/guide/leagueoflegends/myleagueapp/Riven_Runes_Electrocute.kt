package com.guide.leagueoflegends.myleagueapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_riven__runes__electrocute.*

class Riven_Runes_Electrocute : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riven__runes__electrocute)
        val pic = intent.getStringExtra("image")
        val textviewtext = intent.getStringExtra("text")

        Picasso.get().load(pic).into(runes_riven_electrocute_image)
        runes_riven_electrocute_textview.text = textviewtext

    }
}
class Riven_Runes_Predator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riven_runes_predator)
        //val pic = intent.getStringExtra("Rune Picture")
        //val loop = intent.getStringExtra("Current Value")

        //runes_riven_electrocute_image.setImageResource(pic)

    }
}