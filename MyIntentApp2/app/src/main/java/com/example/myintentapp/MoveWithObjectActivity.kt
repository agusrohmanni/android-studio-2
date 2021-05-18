package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {
    companion object{
        const val Extra_Person = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val objectReceived:TextView = findViewById(R.id.tv_ObjectReceived)

        val person = intent.getParcelableExtra<Person>(Extra_Person) as Person
        val text ="Name : ${person.name} " +
                "\nEmail : ${person.email} " +
                "\nAge : ${person.age} " +
                "\nCity : ${person.city}"
        objectReceived.text=text

    }
}