package com.guide.leagueoflegends.myleagueapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
//import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.guide.leagueoflegends.myleagueapp.R.styleable.View

import kotlinx.android.synthetic.main.activity_riven_page.*

class RivenPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riven_page)
        //configureVideoView()

        riven_abilities_button.setOnClickListener {
            val intent = Intent(this, RivenAbilities::class.java)
            startActivity(intent)
        }

        riven_animation_button.setOnClickListener {
            val intent = Intent(this, RivenPage::class.java)
            startActivity(intent)
        }
        riven_builds_button.setOnClickListener {
            val intent = Intent(this, RivenPage::class.java)
            startActivity(intent)
        }
        riven_counters_button.setOnClickListener {
            val intent = Intent(this, RivenPage::class.java)
            startActivity(intent)
        }
        riven_gameplay_button.setOnClickListener {
            val intent = Intent(this, RivenPage::class.java)
            startActivity(intent)
        }
        runes_2018_button.setOnClickListener {
            val intent = Intent(this, RivenPage::class.java)
            startActivity(intent)
        }
    }

    /*private fun configureVideoView() {
        RivenVideo.setVideoPath(
            "/"
        )
        RivenVideo.start()
    }

*/
}
