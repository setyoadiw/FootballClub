package com.setyo.kotlin.latihanrecyclerview

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        initData()

        //kotlin android extension
        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items){

            //Anko Common
            startActivity(intentFor<DetailFootballClub>("nama" to it.name
            ,"gambar" to it.image
            ,"deskripsi" to it.desc).singleTop())

        }


    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_desc)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0),desc[i]))
        }

        //Recycle the typed array
        image.recycle()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
