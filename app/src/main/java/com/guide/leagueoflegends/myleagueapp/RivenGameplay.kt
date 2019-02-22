package com.guide.leagueoflegends.myleagueapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_riven_gameplay.*
import okhttp3.*
import java.io.IOException

class RivenGameplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riven_gameplay)
        gameplay_recyclerview.layoutManager = LinearLayoutManager(this)
        //main_recyclerview.adapter = MainAdapter()

        fetchJSON()
    }

    fun fetchJSON()
    {
        println("Attempting to fetch")

        val url = "https://gist.githubusercontent.com/Afcooper/d33efc465a434c026fe8a8b6e183bdd6/raw/089e8ec37ed4218217567ead1e21a4647df684e0/TestJson"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to retrieve data") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val HomeFeed = gson.fromJson(body, HomeFeed::class.java)

                //this fixes the error that a view hierarchy can touch its views
                runOnUiThread {
                    gameplay_recyclerview.adapter = GameplayAdapter(HomeFeed)
                }
                //To change body of created functions use File | Settings | File Templates.
            }

        })

    }
}