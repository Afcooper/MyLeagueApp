package com.guide.leagueoflegends.myleagueapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_counters.*
import kotlinx.android.synthetic.main.gridview_icon.view.*

class CountersActivity : AppCompatActivity() {

    companion object {
        val rune = "Rune"
        val rune_picture = "Rune Picture"
        val builds = "Build"
        val descriptions = "Description"
        val picture = "Picture"
        val rune_descriptions = "Rune Description"
        val classList = hashMapOf(Pair("BasicBuild", BasicBuild::class.java), Pair("AdrianBuild", AdrianBuild::class.java), Pair("Lethality", Lethality::class.java))
    }

   // var adapter: CounterAdapter? = null
    var CountersList = ArrayList<Counters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counters)
        CountersList.add(Counters("Darius", R.drawable.darius, "With all of the recent buffs to Darius he can pose quite a threat to Riven. Usually you will take conquerer against him because he will go tanky eventually so you need conquerer for the damage. You need to be very careful when trading into darius. I don't recommend trading with him until he misses his q or definitely his e. Either do a q-a and then e and w away for a small amount of damage. The other combo you can do is the full e-q-q-w-q with autos inbetween. Only use this if you can kill him if he doesn't disengage or else you will die. In the laning phase I will let Darius push into me unless I know I will get a level 2 gank from the jungler. If you ran ignite and he didn't you can trade with him level one as long as you're careful. You can shove him in and hit two first then flash w ignite and q should kill him. Other than that I recommend Adrian's Build if you get ahead or else the standard Riven build is your best option if you're behind, ahead or even."))
        CountersList.add(Counters("Teemo", R.drawable.teemo, "Teemo is a very annoying champion for Riven. My favorite option is too cheese teemo by sitting in the farthest brush up top. After the minions hit the wave you can just run at teemo and a-q-a-q-a-q and if you have ignite with long sword you will likely kill him. If you sit in Tri or the other bush he will likely just be invis in lane somewhere. You can use D-Shield and just farm out the lane which can be recommended against a kiting or Auto attacking teemo. I like to go long sword and pressure teemo heavily. If he walks up to you past the caster minions you can e-q-q-w-q and faint towards him like you're going to continue then run away. Another option if you're close enough is q-w-a-e away. TIP: Take one auto before e'ing so minions are aggro'd and if you take second wind or D-Shield you will regenerate while your shield is blocking further damage. I recommend Full Lethality build as long as the teemo isn't going tanky as this will allow you to burst teemo efficiently while not getting destroyed by his q blind. I normally push teemo in as much as possible as the level advantage is great and if he auto's you he will have to deal with the minions."))
        CountersList.add(Counters("Pantheon", R.drawable.pantheon, "Pantheon is one of Riven's greatest early game counters. His Shield will block all of your autos which is a significant source of your damage. I recommend taking D-Shield and second wind as secondaries. Conquerer is good because it'll give you true damage on your abilities you don't need to auto, Electrocute is also viable. I would say only fight pantheon with your minions as this is the way he will take the most damage from you. You will want to out-sustain him in lane and just farm up. E every other q from him and only take extended trades with conquerer up. Short trades are worthwhile since he will block your 1 auto you will use and will outrade you. I would recommend letting pantheon q or auto you so the minions push towards you and a Q level one isn't going to do any damage, it will just waste his mana. Then just wait for ganks or later in the game around BC-Warhammer-NinjaTabi you should be able to 1v1 him or do more in teamfights."))
        CountersList.add(Counters("Kennen", R.drawable.kennen, "Kennen is an annoying champion who will destroy you in lane. You should do the same with any range bully take an auto and then e. I usually will take electrocute and cheese the kennen. Other options are Arcane Comet and the usual conquerer. The Black Cleaver build is probably best vs kennen because they can go kiting tank and you will only be able to kill him with that build. If he's going AP you can go the lethality build. You can cheese kennen by sitting in the far bush or if he is leashing you can sit in tri or the other one. You will out damage him especially if you went long sword. The usual combos against kennen are q-e-q-a-w-q away or back onto him. You can also do q-q-q-a-ew away to proc electrocute and safely get away. You can either farm and go the BC-DD build or you can cheese and trade heavily with long sword to snowball an advantage."))
        CountersList.add(Counters("Renekton", R.drawable.renekton, "Renekton used to be the counter to Riven he would destroy her, but now he isn't too hard to deal with. Just make sure to not fight him with full fury, and be cautious when he has at least one bar of fury. q-w-a-e is a good combo if he is low on fury or if you're near your tower. Using your all in combo e-q-q-w-q is probably best against renekton because now adays you will outdamage him unless he hits you with a fury stacked w. You will want to trade so he doesn't hit you with a fury stacked w or else you should just win the trade. I recommend Adrian's build to outdamage him and snowball easily. The other two builds are viable, lethality less so later on as he will likely go tanky. Look to all in him level 1 and 2 as he will not have all of his abilities and you should outdamage him. Go long sword 3 pots against renekton. Don't fight him in an extended trade with his ultimate or with full fury bar. He will win the extended trade when his ult is up so make sure you can kill him with an all in."))
        CountersList.add(Counters("Jayce", R.drawable.jayce, "Jayce is another ranged bully, another notorious Riven counter. You shouldn't be able to beat a good jayce in lane ever but unless you're high challenger that won't happen. You should take doran's shield and second wind against Jayce. After and auto E, if you will be hit by a q make sure you e. Play passive until he makes a mistake or enter's melee form to gather mana or do damage to you. If you can dodge his abilities and he goes to q you in melee make sure you just e-q-q-w-q and you will out trade him in melee. Only trade with him in range if he is low on mana/health, just transformed and you have your CD's, or in melee range. Always E when he q's onto you because he can just smack you away and you would've taken damage for no reason or else just stay out of range if you used your e to shield a q. Push Jayce in if you can or else you'll just have to wait for ganks or roam. I recommend the normal Riven build as it is the safest option against Jayce."))
        CountersList.add(Counters("Fiora", R.drawable.fiora, "Fiora is pretty much a 50-50 at the start but later in the game Fiora can just destroy you. I almost never w or third q, or R unless I've seen her use her parry. I wouldn't fight fiora level 1 or 2 because she will out trade you. You can go long sword or play more passive with D-Shield, if she goes grasp you will want D-Shield so it's the safer option. Fiora you have several options for runes electrocute is probably the best option. Conquerer, klepto are also viable. I would recommend any of the builds but for most consistent results the regular warhammer-bc build is the best option. For fighting fiora you can use q-w-e, especially near tower for some good damage. e-q-q-w then q away is also potent. The main thing is to stay away from her vitals and to not have her land her parry. I usually let fiora push in as much as possible because you can do short trades near your tower without being punished very easily. You are also more likely to get ganks and avoid ganks by doing this. You don't need to win early you should be winning this matchup between 1-3 items. TIP: When you hit 6 just kite backwards or towards a wall to win the fight."))
        CountersList.add(Counters("Garen", R.drawable.garen, "Garen is a potent pick against Riven. His Q does massive damage and silences you so you can't use your mobility spells. Conquerer is a must against garen and BC-Warhammer is the build to go. I usually recommend q-w-a-ew when facing Garen. You can use the all in e-q-q-w-q combo if he is locked into his e or just used his q. You will want to bait out his w (shield) as this reduces a lot of the damage you will do. It's usually necessary to bait out his shield when all-inning him with your ult. Don't fight him if he uses his q. Usually if you kite him with your q you can bait out his and then go for a trade. You can kill him throughout the whole game but if he goes trinity beware his Q damage especially early."))

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
            counterView.setBackgroundColor(Color.LTGRAY)
            counterView.Counter_Image.setImageResource(counter.Image!!)
            counterView.Counter_Name.text = counter.Name!!

            counterView.setOnClickListener {
                val intent = Intent(counterView.context, Counters_Champion_Activity::class.java)
                when(position) {
                    0-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune", R.drawable.conquereroneshot)
                        intent.putExtra("Build", "BasicBuild")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 2)
                        intent.putExtra(rune_descriptions, 2)
                    }
                    1-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune Picture", R.drawable.electrocuteriven) //riven_runes_electrocute change pic/text to needed
                        intent.putExtra("Build", "Lethality")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 0)
                        intent.putExtra(rune_descriptions, 0)
                    }
                    2-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune Picture", R.drawable.conquereroneshot) //riven_runes_electrocute change pic/text to needed
                        intent.putExtra("Build", "BasicBuild")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 2)
                        intent.putExtra(rune_descriptions, 2)
                    }
                    3-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune Picture", R.drawable.electrocuteriven) //riven_runes_electrocute change pic/text to needed
                        intent.putExtra("Build", "Lethality")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 0)
                        intent.putExtra(rune_descriptions, 0)
                    }
                    4-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune Picture", R.drawable.conquereroneshot) //riven_runes_electrocute change pic/text to needed
                        intent.putExtra("Build", "AdrianBuild")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 3)
                        intent.putExtra(rune_descriptions, 3)
                    }
                    5-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune Picture", R.drawable.conquereroneshot) //riven_runes_electrocute change pic/text to needed
                        intent.putExtra("Build", "BasicBuild")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 2)
                        intent.putExtra(rune_descriptions, 2)
                    }
                    6-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune Picture", R.drawable.electrocuteriven) //riven_runes_electrocute change pic/text to needed
                        intent.putExtra("Build", "BasicBuild")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 2)
                        intent.putExtra(rune_descriptions, 2)
                    }
                    7-> {
                        intent.putExtra("Picture", CountersList[position].Image)
                        intent.putExtra("Rune Picture", R.drawable.conquereroneshot) //riven_runes_electrocute change pic/text to needed
                        intent.putExtra("Build", "BasicBuild")
                        intent.putExtra("Description", CountersList[position].Description)
                        intent.putExtra(rune_picture, 2)
                        intent.putExtra(rune_descriptions, 2)
                    }
                }
                counterView . context . startActivity (intent)
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
