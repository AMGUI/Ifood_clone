package com.example.ifood_kotlin.views.fragments

import android.os.Bundle
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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class LoginFragment : Fragment() {
   private lateinit  var firebasedataBase : DatabaseReference
   private lateinit  var firebaseAuth : FirebaseAuth
   private lateinit  var storageReference :StorageReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val textView : TextView = view.findViewById(R.id.textViewCadastro)
        val longinButton : Button = view.findViewById(R.id.buttonAcesso)
        val emialTextView : TextView = view.findViewById(R.id.editTextTextPersonName)
        val passewordTextView : TextView = view.findViewById(R.id.editTextTextPassword)


        longinButton.setOnClickListener {
           val emial: String = emialTextView.text.toString()
           val passeword: String = passewordTextView.text.toString()
            valiteEmailPassWord(emial,passeword)
        }
        textView.setOnClickListener { framentCadastro() }

        return view
    }

    private fun framentCadastro() {
        findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      //  super.onViewCreated(view, savedInstanceState)

        firebasedataBase = FirebaseDatabase.getInstance().reference
        firebaseAuth = FirebaseAuth.getInstance()
        storageReference = FirebaseStorage.getInstance().reference
    }


    fun getIdUser():String{
        return firebaseAuth.currentUser?.providerId ?: "Not user"
    }


    private fun valiteEmailPassWord(
        emial:String? , passeword: String?
    ):Boolean{
        if(emial == "" ){
            Toast.makeText(context, "Email invalido", Toast.LENGTH_SHORT).show()
            return false
        }

        if(passeword == "" ){
            Toast.makeText(context, "Senha invalido", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }



}