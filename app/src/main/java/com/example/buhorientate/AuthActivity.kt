package com.example.buhorientate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_authentification.*
import kotlinx.android.synthetic.main.activity_authentification.signUpButtonP

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)



        setup()
    }


    private fun setup() {
        title = "Autenticación"

        signInButton.setOnClickListener{
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditText.text.toString()?:"",
                    passwordEditText.text.toString()?:"").addOnCompleteListener {
                        if (it.isSuccessful){
                            startActivity(Intent(this, BussinesHome::class.java))
                        }else{
                            showAlert("Error al iniciar sesion")
                        }
                    }
            }
        }

        bussinesSignUpbutton.setOnClickListener{
            startActivity(Intent(this, BussinesSignUp::class.java))
        }
        signUpButtonP.setOnClickListener{
            startActivity(Intent(this, PersonalSignUp::class.java))
        }
    }


    fun showAlert(errorType:String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(errorType)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }



}