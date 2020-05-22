package com.example.exam

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()

    }

    fun init() {
        auth = FirebaseAuth.getInstance()
        SignUpButton.setOnClickListener {
            Register()
        }
        SignInLink.setOnClickListener {
            startActivity(Intent(this, SigninActivity::class.java))
            finish()
        }
    }

    private fun Register() {
        if (EmailText.text.toString().isEmpty()) {
            EmailText.error = "Please Enter Email Address"
            EmailText.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(EmailText.text.toString()).matches()) {
            EmailText.error = "Please Enter Valid Email Address"
            EmailText.requestFocus()
            return
        }
        if (PassText.text.toString().isEmpty()) {
            PassText.error = "Please Enter Your Password"
            PassText.requestFocus()
            return
        }
        if (PassText.text.toString() != ConfirmPassword.text.toString()) {
            PassText.error = "Please Confirm Password"
            PassText.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(
            EmailText.text.toString(),
            PassText.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(
                        baseContext, "Failed To Register, Try Again",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }
}
    


