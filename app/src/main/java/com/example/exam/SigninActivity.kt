package com.example.exam


import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class SigninActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

    }

    fun init() {
        auth = FirebaseAuth.getInstance()
        SignInButton.setOnClickListener {
            SignIn()
        }
        SignUpLink.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
    }




    private fun SignIn() {
        if (LoginEmailText.text.toString().isEmpty()) {
            LoginEmailText.error = "Please Enter Email Address"
            LoginEmailText.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(LoginEmailText.text.toString()).matches()){
            LoginEmailText.error = "Please Enter Valid Email"
            LoginEmailText.requestFocus()
            return
        }
        if(LoginPassText.text.toString().isEmpty()){
            LoginPassText.error = "Please Enter Your Password"
            LoginPassText.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(LoginEmailText.text.toString(), LoginPassText.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }


}
