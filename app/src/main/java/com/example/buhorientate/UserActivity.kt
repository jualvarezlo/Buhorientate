package com.example.buhorientate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.visitante)
        val registerbutton = findViewById<Button>(R.id.vendedor)
        button.setOnClickListener{
            startActivity(Intent(this, VisitorActivity::class.java))

        }
        registerbutton.setOnClickListener{
            startActivity(Intent(this, ProviderRegister::class.java))

        }

    }
}
