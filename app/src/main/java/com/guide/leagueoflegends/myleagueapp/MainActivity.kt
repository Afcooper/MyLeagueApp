package com.guide.leagueoflegends.myleagueapp


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.guide.leagueoflegends.myleagueapp.R.id.toRiven
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_riven_runes2.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toRiven.setOnClickListener {
            val intent = Intent(this, RivenPage::class.java)
            startActivity(intent)
        }
    }
}
