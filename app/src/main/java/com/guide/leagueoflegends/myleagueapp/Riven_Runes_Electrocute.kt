package com.guide.leagueoflegends.myleagueapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.guide.leagueoflegends.myleagueapp.CountersActivity.Companion.rune_descriptions
import com.guide.leagueoflegends.myleagueapp.CountersActivity.Companion.rune_picture
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_riven__runes__electrocute.*
import kotlinx.android.synthetic.main.activity_riven_runes_predator.*

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
        val textplacement = intent.getIntExtra(rune_descriptions, 0)
        val pictureplacement = intent.getIntExtra(rune_picture, 0)
        riven_runes_predator_textview.text = RivenRunesActivity.texts[textplacement]
        Picasso.get().load(RivenRunesActivity.pictures[pictureplacement]).into(riven_runes_predator_image)
        //val pic = intent.getStringExtra("Rune Picture")
        //val loop = intent.getStringExtra("Current Value")

        //runes_riven_electrocute_image.setImageResource(pic)

    }
}