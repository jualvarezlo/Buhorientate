package com.example.buhorientate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_authentification.*
import kotlinx.android.synthetic.main.activity_bussines_sign_up.*


class BussinesSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bussines_sign_up)
        setup()
    }

    private fun setup(){
        title = "Registro proveedor"

        signUpButtonB.setOnClickListener{
            if (editTextPasswordB.text.toString().equals(editTextConfirmPasswordB.text.toString())) {
                if (editTextEmailAddressB.text.isNotEmpty() && editTextPersonName.text.isNotEmpty() &&
                    editTextBussinesName.text.isNotEmpty() && editTextPhoneB.text.isNotEmpty() &&
                    editTextPasswordB.text.isNotEmpty() && editTextConfirmPasswordB.text.isNotEmpty()
                ){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTextEmailAddressB.text.toString(),
                        editTextPasswordB.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, BussinesHome::class.java))
                        } else {
                            showAlert("Error al registrar su negocio")
                        }
                    }
                }else{
                    showAlert("Por favor ingrese todos los datos")
                }
            }else{
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