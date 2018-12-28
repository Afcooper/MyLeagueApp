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
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_riven_runes2.*
import kotlinx.android.synthetic.main.runes_row.view.*
import okhttp3.*
import java.io.File
import java.io.IOException

class RivenRunesActivity : AppCompatActivity() {
    companion object {
        val runeplacement = hashMapOf<String, Int>(Pair("electrocute", 0), Pair("kleptomancy", 2), Pair("conquerer", 3), Pair("adrian", 4), Pair("aftershock", 5), Pair("grasp", 6), Pair("spellbook", 7), Pair("comet", 8), Pair("aery", 9), Pair("predator", 10))
        val pictures = arrayOf("https://i.imgur.com/AMWKxcM.jpg",

            "https://i.imgur.com/BtX8cRe.jpg",
            "https://i.imgur.com/UEOEOvv.jpg",
            "https://i.imgur.com/XEsY9aq.jpg",
            "https://i.imgur.com/Lgjb8V3.jpg",
            "https://i.imgur.com/sumTOqN.jpg",
            "https://i.imgur.com/HZdB9WY.jpg",
            "https://i.imgur.com/uU7QAVs.jpg",
            "https://i.imgur.com/D98rD9O.jpg",
            "https://i.imgur.com/xVoWCrp.jpg")

        val texts = arrayOf("With this build I recommend going lethality items as it fits the best with the build. Electrocute is good for a short trade in lane and getting out like a q-w-a-e combo. It's also good for bursting your opponent with the long 45 sec cd it has but high burst damage. Go sudden impact for more lethality. Eyeball collection if you think you will snowball or else the other two options are also good. Last option is pretty much interchangable, I like ingenious with lethality items and zombie ward especially because it lowers the CD of sweeper, actives(duskblade and youmoos). I usually go sorcery second with transcendence and either scorch, nimbus cloak, nullifying, or gathering storm. For the stats I almost always go AF(adaptive force), AF, Health/Armor/MR.",


             "With this build I recommend the most when going against a melee champion, mainly a bruiser who you will be fighting a lot. An example is Irelia, Illaoi, etc. You can go bruiser or assassin riven, Bruiser riven would probably be best though because you can effectively utilize the kelpto procs. Usually recommend the boots or stopwatch, usually I go boots. Then I like to go future's market because since you're already making extra gold with klepto, future's market will get you further ahead. For Secondary I like to go transcendence and either nimbus, gathering or nullifying depending on the circumstances. For the stats I like to go AF, AF, Health for the extra damage in lane.",
            "This is my bruiser riven build runes. Conquerer is a must, then either triumph or overheal is good if you plan to go lifesteal. I like bloodline with hydra and bloodthirster for insane healing but the other two options are viable. Coup De Grace is the best option for the last rune. For secondary you can go either resolve for extra tankiness. Shield Bash and Bone plating if you're doing resolve. The other option would be transcendence and gathering storm are your best options for sorcery. For runes I recommend AF, AF, Health/AR/MR. You can switch out first AF for CDR if there's no way you can kill your opponent and are just farming",
            "With this build you should go conquerer for extended trades and for the true damage. This is Adrian Riven's build with essence reaver and stormrazor. Triumph is best option out of the top two. Alacrity is good for auto-attack canceling and fast comboing. Coup de grace is best option because this is a bursty build. Transcendence is never bad and nimbus cloak is good too keep up with the enemy when you're ulting. I like to go AF, AF, Health for the most damage.",
            "This tank build used to be good when tanks were busted but now it's not the most optimal really. Aftershock will proc when you W so use that whenever you need the tank stats or final q. Shield bash is probably the best choice in this tier because it's synergy is amazing with riven and the damage will add up because you're so tanky you can proc it multiple times during a fight. Since you're going tank you could go the resistances, bone-plating, or second wind if needed. Last one either overgrowth or the tenacity perk is most optimal. Secondary transendence can't go wrong with and gathering storm will give you free damage later on since you're not building much. For Stats I would go CDR since you're not doing much damage with aftershock, AR/MR, Any",
            "Grasp build I recommend shield bash because with grasp when you e auto it will do significant poke damage. Bone Plating or second wind is optimal for second tier. Third tier probably would go overgrowth as more health should synergize well with your build. Secondary I would go transcendence and probably gathering storm for the scaling. For stats I would recommend AF, AF, Health because the ad in lane makes your auto's that much stronger while the health goes well with grasp and your build.",
            "Unsealed spellbook used to be very popular when it reduced riven's cd on her flash which is very powerful on riven. Now I believe there are more optimal builds but this is still viable. Usually use this build if you can utilize the summoner spells effectively like ignite/cleanse/exhaust but you need tp later on. Next I prefer boots but stopwatch can also be used. Second tier is pretty much preference. Cosmic insight is probably best for second because it further reduces your cd's and summoner cd's. Second page you can go resolve if you're going to max out cdr else transendence and gathering storm is probably best option. For stats AF, AF, and Health are probably your best options.",
            "Arcane Comet build is best to poke with your Q against jax with his counterstrike and a ranged bully like kennen or jayce. Nimbus cloak or nullifying are best options for first tier. Second tier transendence is a must. Last is either scorch for more damage with your q and comet or you can go gathering storm. Second tier I like to go resolve for some tankiness against the harder matchups. Bone plating or second wind and shield bash are your best options. Next I would go AF, AF, Any",
            "Aery build is worse than conquerer except very early on. You can use this build if you're going to do heavy trading with a-q's. Against irelia, darius, melee champions it does a lot of damage. Nullifying or Nimbus are best. Transendence or you can go even absolute focus is good for lots of damage early just have to be careful about maxing out your CDR. Scorch is probably best with this build for max damage early but gathering storm is also good. Next I like to go either resolve with shield bash and bone plating or domination. With the domination tree I go sudden impact with ravenous hunter or ingenious if going full lethality."
        ,"This is the predator riven build. First three are not interchangable except maybe zombie ward. I like to go zombie ward though because ingenious hunter reduces duskblade and sweeper which makes it very easy to get a bunch of zombie wards. Second tier transcendence is always nice and I recommend waterwalking because you will be ganking with predator a lot. The stats I recommend AF, AF, Any.")

        var loop = 0
    }
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

            /*"C:\Users\Alex\Desktop\Android Pictures\aeryriven.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\aftershockriven.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\bcrivenbuild.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\cometriven.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\conquereroneshot.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\electrocuteriven.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\graspbuild.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\kleptomancyriven.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\predatorriven.jpg"
            "C:\Users\Alex\Desktop\Android Pictures\unsealedspellbook.jpg"
            */
            p0.customView.runes_row_description.text = runerow.Description
            p0.customView.runes_row_title.text = runerow.title
            loop = p1
            val image = p0.customView.runes_row_image
            Picasso.get().load(runerow.PictureUrl).into(image)
            p0?.runerow = runerow

            if(p1 %2 == 0)
            {
                p0?.customView.setBackgroundColor(Color.LTGRAY)
            }
            else p0?.customView.setBackgroundColor(Color.GRAY)

            p0.customView.setOnClickListener {
                val intent = Intent(p0.customView.context, Riven_Runes_Electrocute::class.java)
                intent.putExtra("image", pictures[p1])
                intent.putExtra("text", texts[p1])
                p0.customView.context.startActivity(intent)
            }

        }
    }
    class RunesViewHolder(val customView: View, var runerow: Runes? = null) : RecyclerView.ViewHolder(customView) {
        //var loop = 0
        val rivenactivities = arrayOf(Riven_Runes_Electrocute::class.java, Riven_Runes_Predator::class.java)
        /*init {
            customView.setOnClickListener {
               // var intent = Intent(customView.context, rivenactivities[loop])
                val intent = Intent(customView.context, Riven_Runes_Electrocute::class.java)
                //intent.putExtra("Rune Picture", pictures[loop])
                //loop++

                customView.context.startActivity(intent)
            }
        }*/
    }

}