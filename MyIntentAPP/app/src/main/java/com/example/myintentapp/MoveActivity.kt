package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MoveActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val btnActivityDua: Button = findViewById(R.id.btn_ActivityDua)
        btnActivityDua.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_ActivityDua->{
                val pindah = Intent(this@MoveActivity,MainActivity::class.java)
                startActivity(pindah)
            }
        }
    }
}