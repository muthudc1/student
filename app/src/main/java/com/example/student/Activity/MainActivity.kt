package com.example.student.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.student.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
          val intent =  Intent(this@MainActivity,view::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent =  Intent(this@MainActivity,post::class.java)
            startActivity(intent)
        }


    }
}