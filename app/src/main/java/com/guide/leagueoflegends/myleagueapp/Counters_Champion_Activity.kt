package com.guide.leagueoflegends.myleagueapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.guide.leagueoflegends.myleagueapp.CountersActivity.Companion.builds
import com.guide.leagueoflegends.myleagueapp.CountersActivity.Companion.rune_descriptions
import com.guide.leagueoflegends.myleagueapp.CountersActivity.Companion.rune_picture
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.activity_counters__champion_.*


class Counters_Champion_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counters__champion_)

        val runeplacement = intent.getIntExtra(rune_picture, 4)
        val pictureplacement = intent.getIntExtra(rune_descriptions, 5)
        Picasso.get().load(intent.getIntExtra(CountersActivity.picture, R.drawable.cometriven)).into(activity_counters_champion_champion_image2) //sets image of the champion
        //activity_counters_champion_build_recommended.text = intent.getStringExtra(CountersActivity.builds)  //sets the text to the correct build
        activity_counters_champion_build_recommended.setOnClickListener {
            val intent = Intent(this, CountersActivity.classList.get(intent.getStringExtra(CountersActivity.builds))) //opens up correct activity for build
            startActivity(intent)
        }
        activity_counters_champion_description.text = intent.getStringExtra(CountersActivity.descriptions) // sets the text to the description
        activity_counters_champion_runes_recommended.setOnClickListener {
            val intent = Intent(this, Riven_Runes_Predator::class.java)
            intent.putExtra(
                rune_picture, runeplacement)
            intent.putExtra(
                rune_descriptions, pictureplacement)
            startActivity(intent)
        }
        intent.getStringExtra(CountersActivity.builds)
    }
}
