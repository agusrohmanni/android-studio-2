package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MoveWithData : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val Extra_Age = "extra_age"
        const val Extra_Name = "extra_name"
        const val Nama_Depan = "nama_depan"
        const val Umur = "Umur"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvTerimaData: TextView = findViewById(R.id.tv_TerimaData)
        val tvDataSatu: TextView = findViewById(R.id.tv_DataSatu)
        val btnKembali: TextView = findViewById(R.id.btn_Kembali)

        btnKembali.setOnClickListener(this)

        val nama = intent.getStringExtra(Extra_Name)
        val age = intent.getIntExtra(Extra_Age,0)
        val namaDepan = intent.getStringExtra(Nama_Depan)
        val umur = intent.getIntExtra(Umur,0)


        val text = "Nama : $nama \n  Age : $age"
        val data = "Nama : $namaDepan \n Age : $umur"
        tvTerimaData.text= text
        tvDataSatu.text= data
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_Kembali->{
                val kembali = Intent(this@MoveWithData,MainActivity::class.java)
                startActivity(kembali)
            }
        }
    }
}