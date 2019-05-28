package com.example.chat

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class EditMessageAcitivty : AppCompatActivity() {
    private var userLogin: String = ""
    private var login: String = ""
    private var id: String = ""
    private var content: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_edit_message_acitivty)
/*
        login = intent.getStringExtra("login")
        edit_login.setText(login)
        content = intent.getStringExtra("content")
        edit_content.setText(content)
        userLogin = intent.getStringExtra("user_login")
        id = intent.getStringExtra("id")

        update_button.setOnClickListener{
            checkUpdate()
        }

        delete_button.setOnClickListener{
            checkDelete()
        }
    }

    private fun checkUpdate(){
        if (edit_login.text.toString() != ""  && edit_content.text.toString() != ""){
            val res = Intent()
            res.putExtra("TYPE", "UPDATE")
            res.putExtra("login", login)
            res.putExtra("content", content)
            res.putExtra("id", id)

            setResult(Activity.RESULT_OK, res)
            finish()
        }
    }

    private fun checkDelete(){
        if(userLogin == login){
            val res = Intent()
            res.putExtra("TYPE", "DELETE")
            res.putExtra("id", id)

            setResult(Activity.RESULT_OK, res)
            finish()
        }
        */
    }

}