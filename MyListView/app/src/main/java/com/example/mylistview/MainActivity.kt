package com.example.mylistview

import android.accounts.AuthenticatorDescription
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter :HeroAdapter
    private lateinit var dataNama: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var imgFoto: TypedArray
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter= HeroAdapter(this)
        listView.adapter = adapter
        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{_,_, position,_-> Toast.makeText(this@MainActivity, heroes[position].nama, Toast.LENGTH_SHORT).show()}
    }
    private fun prepare(){
        dataNama = resources.getStringArray(R.array.data_name)
        dataDescription =  resources.getStringArray(R.array.data_description)
        imgFoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem(){
        for(position in dataNama.indices){
            val hero = Hero(
                imgFoto.getResourceId(position,-1),
                dataNama[position],
                dataDescription[position]
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }
}