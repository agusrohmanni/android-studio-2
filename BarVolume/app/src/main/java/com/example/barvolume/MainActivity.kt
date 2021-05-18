package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StatFs
import android.view.AbsSavedState
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var Panjang: EditText
    private lateinit var Lebar: EditText
    private lateinit var Tinggi: EditText
    private lateinit var Hasil: TextView
    private lateinit var  BtnHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Panjang= findViewById(R.id.panjang)
        Lebar= findViewById(R.id.lebar)
        Tinggi= findViewById(R.id.tinggi)
        Hasil= findViewById(R.id.tv_Hasil)
        BtnHitung= findViewById(R.id.btn_hitung)

        BtnHitung.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(StateResult)
            Hasil.text= result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(StateResult,Hasil.text.toString())
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_hitung->{
                val Ipanjang = Panjang.text.toString().trim()
                val Ilebar = Lebar.text.toString().trim()
                val Itinggi = Tinggi.text.toString().trim()

                var isKosong= false

                if (Ipanjang.isEmpty()){
                    isKosong=true
                    Panjang.error= "Tidak boleh Kosong"
                }
                else if(Ilebar.isEmpty()){
                    isKosong= true
                    Lebar.error= "Tidak Boleh Kosong"
                }
                else if (Itinggi.isEmpty()) {
                    isKosong= true
                    Tinggi.error= "Tidak Boleh Kosong"
                }
                else{
                    if (!isKosong){
                        val Ohasil= Ipanjang.toDouble() * Ilebar.toDouble() * Itinggi.toDouble()
                        Hasil.text= Ohasil.toString()
                    }
                }
            }
        }
    }

    companion object{
        private const val StateResult = "State Result"
    }

}