package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithData : AppCompatActivity() {
    companion object{
        const val EXTRA_AGE= "extra_age"
        const val EXTRA_NAMA= "extra_nama"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvTerimaData: TextView = findViewById(R.id.tv_TerimaData)

        val nama = intent.getStringExtra(EXTRA_NAMA)
        val umur = intent.getIntExtra(EXTRA_AGE,0)

        val text = "Nama : $nama \n Umur : $umur"

        tvTerimaData.text=text
    }
}