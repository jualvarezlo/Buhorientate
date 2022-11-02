package com.example.buhorientate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BussinesHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bussines_home)
    }
    private fun setUp(){
        title = "Negocios Home"
    }
}