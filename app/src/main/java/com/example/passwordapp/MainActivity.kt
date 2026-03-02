package com.example.passwordapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvTitle = findViewById<TextView>(R.id.tvMainTitle)
        val edtUsername = findViewById<EditText>(R.id.edtTextMainUsername)
        val edtPassword = findViewById<EditText>(R.id.edtPwMainPassword)
        val edtConfirmPassword = findViewById<EditText>(R.id.edtPwMainConfirmPassword)
        val btnLogin = findViewById<Button>(R.id.btnMainLogin)

        var username: String
        var password: String
        var confirmPassword: String

        btnLogin.setOnClickListener()
        {
            username = edtUsername.text.toString()
            password = edtPassword.text.toString()
            confirmPassword = edtConfirmPassword.text.toString()

            if(username.length > 8 || username.length == 8)
            {
                if(password != confirmPassword || password.isEmpty())
                {
                    tvTitle.text = "Passwords incorrect"
                }
                else
                {
                    tvTitle.text = "Login Successful"
                }
            }
            else {
                tvTitle.text = "Username must be at least 8 characters"
            }
        }
    }
}