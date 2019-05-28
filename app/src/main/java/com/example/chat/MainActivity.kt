package com.example.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import retrofit2.*
import android.widget.EditText
import retrofit2.Call
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    private var nick: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        /*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
*/
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        /*
        val sharedPref = getSharedPreferences("log", Context.MODE_PRIVATE) ?: return
        userLogin = sharedPref.getString("login", null )
        if(userLogin == null) {

        }


    */
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter { item -> itemClicked(item)}
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        /*
        getNewMessages()
        //send button listener
        send_button.setOnClickListener{
            sendNewMessage(input_message.text.toString())
            input_message.text.clear()
            input_message.clearFocus()
            it.hideKeyboard()
        }
    */
    }

    private fun itemClicked(Item : Message) {
        Toast.makeText(this, "Clicked: ${Item.id}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, EditMessageAcitivty::class.java)
        intent.putExtra("login", Item.login)
        intent.putExtra("content", Item.content)
        intent.putExtra("id", Item.id)
        intent.putExtra("user_login", nick)
        startActivityForResult(intent, 1)
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences("log", Context.MODE_PRIVATE) ?: return
        var userLogin = sharedPref.getString("login", null )


        nick = userLogin.toString()

    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_manage -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun getNewMessages(){

        val service = Service.create()
        val call = service.getMessages()


        call.enqueue(object : Callback<MutableList<Message>>{
            override fun onResponse(call: Call<MutableList<Message>>, response: Response<MutableList<Message>>) {
                if(response.code() == 200){
                    recyclerAdapter.setMessageListItems(response.body()!!)
                }
            }

            override fun onFailure(call: Call<MutableList<Message>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}

