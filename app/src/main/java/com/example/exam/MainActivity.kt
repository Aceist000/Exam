package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log.d as d

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init()
    {
        auth = FirebaseAuth.getInstance()
        SingOut.setOnClickListener {
            LogOut()
        }
        BrowseButton.setOnClickListener{
            startActivity(Intent(this,BrowseActivity::class.java))
        }
        val currentUser = auth.currentUser
        if(currentUser==null){
            startActivity(Intent(this,SigninActivity::class.java))
            d("User", currentUser.toString())
            finish()
        }

    }

    private fun LogOut()
    {
        auth.signOut()
        startActivity(Intent(this,SigninActivity::class.java))
        finish()
    }

}


