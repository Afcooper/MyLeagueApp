package com.guide.leagueoflegends.myleagueapp

import android.app.Activity
import android.support.v4.app.Fragment

class rivenFragments(val Fragment: Fragment, val Title:String)

class Runes(val PictureUrl: String, val title: String, val Description: String)

class Counters(var Name: String?, var Image: Int?, var Description: String)

class Builds(val Image: Int?, val Title: String?, val Description: String?)