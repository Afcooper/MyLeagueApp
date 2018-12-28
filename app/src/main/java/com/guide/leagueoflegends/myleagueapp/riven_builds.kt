package com.guide.leagueoflegends.myleagueapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_riven_builds.*
import kotlinx.android.synthetic.main.builds_row.view.*

class riven_builds : AppCompatActivity() {

    val BuildsList = arrayOf(Builds(R.drawable.blackcleaver, "Basic Build", "The most basic riven build, can be built every game"),
        Builds(R.drawable.essencereaver, "Adrian Riven Build", "Bursty build by Adrian Riven"),
        Builds(R.drawable.duskblade, "Full Lethality", "Bursty build from your abilities")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riven_builds)

        riven_builds_recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = BuildsAdapter(BuildsList)

        riven_builds_recyclerview.adapter = adapter

    }

    class BuildsAdapter(val BuildsList: Array<Builds>): RecyclerView.Adapter<BuildView>()
    {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BuildView {
            val layout = LayoutInflater.from(p0.context)
            val buildrow = layout.inflate(R.layout.builds_row, p0, false)

            return BuildView(buildrow)
        }

        override fun getItemCount(): Int {
            return BuildsList.size
        }

        override fun onBindViewHolder(p0: BuildView, p1: Int) {

            p0.buildView.builds_row_description.text = BuildsList.get(p1).Description
            p0.buildView.builds_row_title.text = BuildsList.get(p1).Title

            Picasso.get().load(BuildsList.get(p1).Image!!).into(p0.buildView.builds_row_image)

            if (p1 % 2 == 0) {
                p0?.buildView.setBackgroundColor(Color.LTGRAY)
            } else p0?.buildView.setBackgroundColor(Color.GRAY)

            p0.buildView.setOnClickListener {
                when (p1) {
                    0 -> {
                        val intent = Intent(p0.buildView.context, BasicBuild::class.java)
                        p0.buildView.context.startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(p0.buildView.context, AdrianBuild::class.java)
                        p0.buildView.context.startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(p0.buildView.context, Lethality::class.java)
                        p0.buildView.context.startActivity(intent)
                    }
                    else -> Toast.makeText(p0.buildView.context, "error", Toast.LENGTH_LONG).show()
                }
            }
        }
        }



    class BuildView(val buildView: View): RecyclerView.ViewHolder(buildView)

}
