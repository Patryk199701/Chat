package com.example.chat

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var setter : Button = findViewById(R.id.setLogin)
        setter.setOnClickListener(){
            setSharedPrefLogin()
        }

    }

    private fun setSharedPrefLogin(){
        val loginLabel : EditText = findViewById(R.id.login)
        val sharedPref = getSharedPreferences("log", Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("login", loginLabel.text.toString())
            apply()
        }
        finish()

    }

}
