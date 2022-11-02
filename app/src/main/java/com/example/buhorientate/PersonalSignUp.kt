package com.example.buhorientate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_bussines_sign_up.*
import kotlinx.android.synthetic.main.activity_personal_sign_up.*

class PersonalSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_sign_up)

        setUp()
    }

    private fun setUp() {
        title = "Personal Home"

        signUpButtonP.setOnClickListener {
            if (editTextPasswordP.text.toString().equals(editTextConfirmPasswordP.text.toString())
            ) {
                if (editTextEmailAddressP.text.isNotEmpty() && editTextNameP.text.isNotEmpty() &&
                    editTextPhoneP.text.isNotEmpty() && editTextPasswordP.text.isNotEmpty() &&
                    editTextConfirmPasswordP.text.isNotEmpty()
                ) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        editTextEmailAddressP.text.toString(),
                        editTextPasswordP.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, PersonalHome::class.java))
                        } else {
                            showAlert("Error al registrar su usuario")
                        }
                    }
                } else {
                    showAlert("Por favor ingrese todos los datos")
                }
            }else {
                showAlert("Las contraseñas no coinciden")
            }
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