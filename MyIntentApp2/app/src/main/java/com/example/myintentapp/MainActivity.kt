package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    companion object{
        private const val Request_Code=110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.btn_pindah)
        val btnPindahData: Button = findViewById(R.id.btn_pindahData)
        val btnPindahObjek: Button = findViewById(R.id.btn_pidahObject)
        val btnDiall: Button = findViewById(R.id.btn_Diall)
        val btnHasil: Button = findViewById(R.id.btn_Pganda)
        tvResult= findViewById(R.id.tv_HasilActivity)

        btnPindahActivity.setOnClickListener(this)
        btnPindahData.setOnClickListener(this)
        btnPindahObjek.setOnClickListener(this)
        btnDiall.setOnClickListener(this)
        btnHasil.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_pindah->{
                val bPindah= Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(bPindah)
            }
            R.id.btn_pindahData->{
                val pData= Intent( this@MainActivity, MoveWithData::class.java)
                pData.putExtra(MoveWithData.EXTRA_NAMA,"Agus Sugento")
                pData.putExtra(MoveWithData.EXTRA_AGE,50)

                startActivity(pData)
            }
            R.id.btn_pidahObject->{
                val person = Person(
                    name = "Susilo Bambang Yudoyono",
                    age = 67,
                    email = "SBY@gmail.com",
                    city = "Boyolali"
                )
                val objek= Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                objek.putExtra(MoveWithObjectActivity.Extra_Person,person)
                startActivity(objek)
            }
            R.id.btn_Diall->{
                val Phone = "08995338000"
                val diallPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$Phone"))
                startActivity(diallPhone)
            }
            R.id.btn_Pganda->{
                val Pilih= Intent(this@MainActivity,MoveResultActivity::class.java)
                startActivityForResult(Pilih, Request_Code)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==Request_Code){
            if (resultCode==MoveResultActivity.Hasil_Code){
                val selectedValue = data?.getIntExtra(MoveResultActivity.Selected_Value,0)
                tvResult.text= "Hasil : $selectedValue"
            }
        }
    }
}