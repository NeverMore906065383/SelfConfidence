package com.example.selfconfidence.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.selfconfidence.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
    }

    private fun initData() {

    }

    private fun initView() {

    }

    fun save(view: View) {
        findViewById<TextView>(R.id.tv_info).text = "hhahahh®"
        Toast.makeText(this, "i am toast", Toast.LENGTH_SHORT).show()
    }
}