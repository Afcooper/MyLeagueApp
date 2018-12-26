package com.guide.leagueoflegends.myleagueapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_counters.*
import kotlinx.android.synthetic.main.gridview_icon.view.*

class CountersActivity : AppCompatActivity() {

   // var adapter: CounterAdapter? = null
    var CountersList = ArrayList<Counters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counters)

        CountersList.add(Counters("Darius", R.drawable.darius))
        CountersList.add(Counters("Teemo", R.drawable.teemo))
        CountersList.add(Counters("Pantheon", R.drawable.pantheon))
        CountersList.add(Counters("Kennen", R.drawable.kennen))
        CountersList.add(Counters("Renekton", R.drawable.renekton))
        CountersList.add(Counters("Jayce", R.drawable.jayce))
        CountersList.add(Counters("Fiora", R.drawable.fiora))

        val adapter = CounterAdapter(this, CountersList)

        gridview_counters.adapter = adapter
    }

    class CounterAdapter : BaseAdapter  {

        var CountersList = ArrayList<Counters>()
        var context: Context? = null

        constructor(context: Context, counterslist: ArrayList<Counters>):super()
        {
            this.context = context
            this.CountersList = counterslist
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val counter = this.CountersList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var counterView = inflator.inflate(R.layout.gridview_icon, null)

            counterView.Counter_Image.setImageResource(counter.Image!!)
            counterView.Counter_Name.text = counter.Name!!

            counterView.setOnClickListener {
                val intent = Intent(counterView.context, Counters_Garen::class.java)
                counterView.context.startActivity(intent)
            }
            return counterView
        }

        override fun getItem(position: Int): Any {
        return CountersList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return CountersList.size
        }
    }
}
