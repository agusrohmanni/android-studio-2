package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.btn_PindahActivity)
        btnPindahActivity.setOnClickListener(this)

        val btnPindahData: Button = findViewById(R.id.btn_PindahData)
        btnPindahData.setOnClickListener(this)

        val btnTelfon: Button = findViewById(R.id.btn_Telfon)
        btnTelfon.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_PindahActivity->{
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_PindahData->{
                val moveData = Intent(this@MainActivity, MoveWithData::class.java)
                moveData.putExtra(MoveWithData.Extra_Name,"Budi Sudirman")
                moveData.putExtra(MoveWithData.Extra_Age,22)
                moveData.putExtra(MoveWithData.Nama_Depan,"Agus Suherman")
                moveData.putExtra(MoveWithData.Umur,20)
                startActivity(moveData)
            }
            R.id.btn_Telfon->{
                val nomorTelfon = "08995338000"
                val dialPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $nomorTelfon"))
                startActivity(dialPhone)
            }
        }
    }
}