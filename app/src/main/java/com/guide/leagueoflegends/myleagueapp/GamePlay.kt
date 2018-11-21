package com.guide.leagueoflegends.myleagueapp

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_riven_abilities.*
import com.guide.leagueoflegends.myleagueapp.YoutubeConfig.getApiKey
import kotlinx.android.synthetic.main.activity_game_play.*


/*class GamePlay : YouTubeBaseActivity() {
    private final val TAG = "GamePlay"
    lateinit var mYoutubePlayerView: YouTubePlayerView
    val youtubeButton = findViewById<Button>(R.id.youtubeButton)
    val mYouTubePlayerView = findViewById<YouTubePlayerView>(R.id.RivenQPlayer)
    lateinit var mOnInitializedListener: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)
        Log.d(TAG, "onCreate: Starting")
        //mYoutubePlayerView = findViewById<YouTubePlayerView>(R.id.youtubeButton)
        //tabs_main.setupWithViewPager(viewpager_main)
        //mYouTubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener)
        //initUI()






    //private fun initUI() {
        //val youtubeButton = findViewById<Button>(R.id.youtubeButton)
        //val mYouTubePlayerView = findViewById<YouTubePlayerView>(R.id.RivenQPlayer)
        val mOnInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {
                Log.d(TAG, "onClick: Done initializing")
                val youtubelist = listOf("pQ8Ni5hI4Gw", "yl1IWGXM9P4", "U8938F0Uy9o")

                youtubePlayer?.loadVideos(youtubelist) //To change body of created functions use File | Settings | File Templates.
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Log.d(TAG, "onClick: Failed to initialize.")
                //Toast.makeText(applicationContext, "something went wrong!", Toast.LENGTH_SHORT).show() //To change body of created functions use File | Settings | File Templates.
            }
        }
        youtubeButton.setOnClickListener(View.OnClickListener { v->
            mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener)
        })


    }
}
*/

class GamePlay : YouTubeBaseActivity() {
    lateinit var mOnInitializedListener: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Starting.")
        //val btnPlay = findViewById<Button>(R.id.youtubeButton)
        //val mYouTubePlayerView = findViewById<YouTubePlayerView>(R.id.RivenQPlayer)

        val mOnInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, b: Boolean) {
                Log.d(TAG, "onClick: Done initializing.")
                //List videoList = new ArrayList<>();
                //videoList.add("nQwkCb_eq50");
                //videoList.add("2duc77R4Hqw");
                //youTubePlayer.loadVideos(videoList);
                val youtubelist = listOf("pQ8Ni5hI4Gw", "yl1IWGXM9P4", "U8938F0Uy9o")
                youTubePlayer?.loadVideos(youtubelist)
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                youTubeInitializationResult: YouTubeInitializationResult
            ) {
                Log.d(TAG, "onClick: Failed to initialize.")
            }
        }

        if(btnPlay != null) {
            btnPlay.setOnClickListener { v ->
                youtubePlay.initialize(API_KEY, mOnInitializedListener)
            }
        }
        else
        {
            Log.d(TAG, "whoops")
        }
    }

    companion object {

        private val TAG = "MainActivity"
        val API_KEY = "AIzaSyD4i2Vm3rNX6y9fRlL7tWpXjP41YZEhN-I"
    }
}