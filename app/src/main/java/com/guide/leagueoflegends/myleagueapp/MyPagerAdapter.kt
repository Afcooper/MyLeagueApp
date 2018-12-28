package com.guide.leagueoflegends.myleagueapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.guide.leagueoflegends.myleagueapp.fragments.*

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    companion object {
        val FragmentList = arrayOf(rivenFragments(FirstFragment(), "Riven's Passive"), rivenFragments(SecondFragment(), "Riven's Q"),rivenFragments(
            ThirdFragment(), "Riven's W"), rivenFragments(FourthFragment(), "Riven's E"),rivenFragments(
            FifthFragment(), "Ultimate"))
    }
    override fun getItem(position: Int): Fragment {
        return FragmentList.get(position).Fragment
        /*return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourthFragment()
            else ->
            {
                return FifthFragment()
            }
        }*/

    }

    override fun getCount(): Int {
        return FragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return FragmentList[position].Title
       /* return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
        }*/
    }
}