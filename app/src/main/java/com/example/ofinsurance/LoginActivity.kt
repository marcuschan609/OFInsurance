package com.example.ofinsurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.ofinsurance.databinding.ActivityLoginBinding
import com.google.android.material.navigation.NavigationView

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        var usernameed = findViewById<EditText>(R.id.usernameed)
        var passworded = findViewById<EditText>(R.id.passworded)
        var loginbtn = findViewById<Button>(R.id.loginbtn)

        loginbtn.setOnClickListener {
            if (usernameed.toString().isEmpty()) {
                Toast.makeText(this, "Input Required", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()

            }
        }
    }
}