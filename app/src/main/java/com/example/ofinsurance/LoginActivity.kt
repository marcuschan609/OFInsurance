package com.example.ofinsurance

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ofinsurance.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().getReference("Users")
        firebaseAuth = FirebaseAuth.getInstance()

        binding.contactUs.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:60167106096"))
            startActivity(intent)
        }

        binding.registerbtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.loginbtn.setOnClickListener {
            val email: String = binding.emailed.text.toString()
            val pass = binding.passworded.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        database.child(pass).get().addOnSuccessListener {
                            val username = it.child("username").value
                            Toast.makeText(this, "Logging in Now...", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        }
                    } else {

                        Toast.makeText(this, "Invalid Details.", Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }


}