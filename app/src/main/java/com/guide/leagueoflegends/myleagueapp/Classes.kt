package com.guide.leagueoflegends.myleagueapp

import android.app.Activity
import android.support.v4.app.Fragment

class rivenFragments(val Fragment: Fragment, val Title:String)

class Runes(val PictureUrl: String, val title: String, val Description: String)

class Counters(var Name: String?, var Image: Int?, var Description: String)

class Builds(val Image: Int?, val Title: String?, val Description: String?)

class HomeFeed(val videos: List<Video>)

class Video(val id: Int, val name: String, val link: String, val imageUrl: String, val numberOfViews: Int, val channel: Channel)

class Channel(val name: String, val profileImageUrl: String)

class CourseLesson(val name: String, val duration: String, val number:Int, val imageUrl: String, val link: String){
    //[{"name":"Creating a Registration Screen","duration":"21:50","number":1,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/d6938a65-b273-421b-976a-40cf923a17ba_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=1022"},{"name":"Firebase SDK and User Registration","duration":"17:34","number":3,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/ef96b470-785c-4fed-bad7-d2cc972932fd_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=1042"},{"name":"Setting up Push Notifications with FCM","duration":"27:22","number":43,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/d976ee60-07fa-4ced-a5b9-77c0dd66129e_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=2282"},{"name":"Tap Push Notification Action","duration":"16:29","number":47,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/a1947421-8901-4388-a8b8-f4267f0ef82a_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=2332"},{"name":"Creating a Registration Screen","duration":"21:50","number":1,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/d6938a65-b273-421b-976a-40cf923a17ba_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=1022"},{"name":"Firebase SDK and User Registration","duration":"17:34","number":3,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/ef96b470-785c-4fed-bad7-d2cc972932fd_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=1042"},{"name":"Setting up Push Notifications with FCM","duration":"27:22","number":43,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/d976ee60-07fa-4ced-a5b9-77c0dd66129e_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=2282"},{"name":"Tap Push Notification Action","duration":"16:29","number":47,"imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/a1947421-8901-4388-a8b8-f4267f0ef82a_thumbnail","link":"https://www.letsbuildthatapp.com/course_video?id=2332"}]
}