package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnPilih: Button
    private lateinit var rgNumber: RadioGroup

    companion object{
        const val Selected_Value= "selected value"
        const val Hasil_Code= 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_result)

        btnPilih= findViewById(R.id.btn_Pilih)
        rgNumber= findViewById(R.id.rg_Number)

        btnPilih.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_Pilih ){
            if (rgNumber.checkedRadioButtonId>0){
                var number= 0
                when(rgNumber.checkedRadioButtonId){
                    R.id.rb_50-> number=50
                    R.id.rb_100-> number=100
                    R.id.rb_150-> number=150
                    R.id.rb_200-> number=200
                }
                val hasil =Intent()
                hasil.putExtra(Selected_Value,number)
                setResult(Hasil_Code,hasil)
                finish()
            }
        }
    }
}