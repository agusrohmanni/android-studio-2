package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var etTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPanjang = findViewById(R.id.et_Panjang)
        etLebar = findViewById(R.id.et_Lebar)
        etTinggi = findViewById(R.id.et_Tinggi)
        btnHitung = findViewById(R.id.btn_Hitung)
        tvHasil = findViewById(R.id.tv_Hasil)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_Hitung){
            val inputPanjang = etPanjang.text.toString().trim()
            val inputLebar = etLebar.text.toString().trim()
            val inputTinggi = etTinggi.text.toString().trim()
            var isKosong = false

            when{
                inputPanjang.isEmpty()->{
                    isKosong=true
                    etPanjang.error = "Field tidak boleh kosong"
                }
                inputLebar.isEmpty()->{
                    isKosong=true
                    etLebar.error = "Field tidak boleh kosong"
                }
                inputTinggi.isEmpty()->{
                    isKosong=true
                    etTinggi.error = "Field tidak boleh kosong"
                }
//                boleh menggunakan seperti ini namun isKosong diatas harus mati
//                else->{
//                    isKosong=true
//                    if (isKosong){
//                        val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
//                        tvHasil.text = volume.toString()
//                    }
//                }
            }
                    if (!isKosong){
                        val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                        tvHasil.text = volume.toString()
                    }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvHasil.text.toString())
    }
}