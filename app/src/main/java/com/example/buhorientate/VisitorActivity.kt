package com.example.buhorientate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_provider_register.*

class VisitorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provider_register)
        setup()
    }

    private fun setup(){
        title = "Registro visitante"

        var email = editTextEmailAddress.text
        var personalName = editTextPersonName.text
        var bussinesName = editTextBussinesName.text
        var cellPhoneNumber = editTextPhone.text
    }
}