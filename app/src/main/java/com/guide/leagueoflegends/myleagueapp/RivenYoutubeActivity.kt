package com.guide.leagueoflegends.myleagueapp

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.guide.leagueoflegends.myleagueapp.R.id.WebView_Course_Lesson
import kotlinx.android.synthetic.main.activity_gameplay_video.*

class RivenYoutubeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_gameplay_video)
        //WebView_Course_Lesson.setBackgroundColor(Color.YELLOW)
        val courselink = intent.getStringExtra(RivenVideoDetailActivity.CourseViewHolder.COURSE_LESSON_LINK_KEY)
        WebView_Course_Lesson.settings.javaScriptEnabled = true
        WebView_Course_Lesson.settings.loadWithOverviewMode = true
        WebView_Course_Lesson.settings.useWideViewPort = true


        WebView_Course_Lesson.loadUrl(courselink)


    }
}
