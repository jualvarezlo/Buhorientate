package com.example.buhorientate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_authentification.*
import kotlinx.android.synthetic.main.activity_main.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)

        setup()
    }

    private fun setup() {
        title = "Autenticación"
        val sendbutton = findViewById<Button>(R.id.visitante)
        val sendbutton2 = findViewById<Button>(R.id.vendedor)
        signUpButton.setOnClickListener{
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
    private fun showAlert(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptat", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }



}