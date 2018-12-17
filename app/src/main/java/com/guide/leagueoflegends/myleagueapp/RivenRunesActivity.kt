package com.guide.leagueoflegends.myleagueapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_riven_runes2.*
import kotlinx.android.synthetic.main.runes_row.view.*
import okhttp3.*
import java.io.IOException

class RivenRunesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riven_runes2)

        riven_runes2_recyclerview.layoutManager = LinearLayoutManager(this)
        val url = "https://gist.githubusercontent.com/Afcooper/099bb13efcd8df92c3d7ec6280ab9eea/raw/8cbd1d155455219ce17de3fb61bd4b41a6eb06aa/Runes"
        fetchJSON()
    }


    fun fetchJSON() {
        val url =
            "https://gist.githubusercontent.com/Afcooper/099bb13efcd8df92c3d7ec6280ab9eea/raw/8cbd1d155455219ce17de3fb61bd4b41a6eb06aa/Runes"
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to retrieve data")
            }


            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()

                val Rune = gson.fromJson(body, Array<Runes>::class.java)

                runOnUiThread {
                    riven_runes2_recyclerview.adapter = rivenRunesAdapter(Rune)
                }
            }
        })
    }


    class rivenRunesAdapter(val runesArray: Array<Runes>) : RecyclerView.Adapter<RunesViewHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RunesViewHolder {
            val layoutInflater = LayoutInflater.from(p0.context)
            val cellrows = layoutInflater.inflate(R.layout.runes_row, p0, false)

            return RunesViewHolder(cellrows)
        }

        override fun getItemCount(): Int {
            return runesArray.size
        }

        override fun onBindViewHolder(p0: RunesViewHolder, p1: Int) {
            val runerow = runesArray.get(p1)
            p0.customView.runes_row_description.text = runerow.Description
            p0.customView.runes_row_title.text = runerow.title

            val image = p0.customView.runes_row_image
            Picasso.get().load(runerow.PictureUrl).into(image)
            p0?.runerow = runerow

        }
    }

    class RunesViewHolder(val customView: View, var runerow: Runes? = null) : RecyclerView.ViewHolder(customView) {
        init {
            customView.setOnClickListener {
                val intent = Intent(customView.context, RivenRunesActivity::class.java)
                customView.context.startActivity(intent)
            }
        }
    }

}