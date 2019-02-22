package com.guide.leagueoflegends.myleagueapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity()    {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        activity_login_button_login.setOnClickListener {
            val email = activity_login_textview_email.text.toString()
            val password = activity_login_textview_password.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {

            }
        }
    }
}