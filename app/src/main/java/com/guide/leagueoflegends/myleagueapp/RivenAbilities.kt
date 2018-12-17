package com.guide.leagueoflegends.myleagueapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video.Thumbnails.VIDEO_ID
import android.view.View
import android.widget.Button
import android.widget.Toast
//import com.google.android.youtube.player.YouTubePlayer
//import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
//import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_riven_abilities.*
//import com.google.android.youtube.*
//import com.google.android.youtube.player.YouTubeBaseActivity
//import com.google.android.youtube.player.YouTubeInitializationResult

class RivenAbilities : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riven_abilities)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        //mYoutubePlayerView = findViewById<YouTubePlayerView>(R.id.youtubeButton)
        tabs_main.setupWithViewPager(viewpager_main)
    }

}
