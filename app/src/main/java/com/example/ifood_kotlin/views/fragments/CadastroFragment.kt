package com.example.ifood_kotlin.views.fragments

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ifood_kotlin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class CadastroFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private  var password: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_cadastro, container, false)


        val tPassword:String = view.findViewById<TextView>(R.id.fistTextPassword).text.toString()
        val cPassword:String = view.findViewById<TextView>(R.id.confirmTextPassword).text.toString()

        val buttonCancel = view.findViewById<Button>(R.id.buttonCancelar)
        val buttonCadas = view.findViewById<Button>(R.id.buttonCadas)

        buttonCancel.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
        }

        buttonCadas.setOnClickListener {
            password = tPassword
           // firebaseAuth = Firebase.auth
            val email:String = view.findViewById<TextView>(R.id.editTextfirstEmail).text.toString()

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Activity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = firebaseAuth.currentUser

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(context, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }
                }

        }

        return view
    }


     override fun onStart() {
        super.onStart()
         firebaseAuth = Firebase.auth
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = firebaseAuth.currentUser
        if(currentUser != null){
            Toast.makeText(context, "Sem conexão", Toast.LENGTH_SHORT).show()
        }
    }


}