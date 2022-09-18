package com.example.ofinsurance
//dasd
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ofinsurance.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        var usernameed = findViewById<EditText>(R.id.usernameed)
        var passworded = findViewById<EditText>(R.id.passworded)
        var loginbtn = findViewById<Button>(R.id.loginbtn)

        loginbtn.setOnClickListener {
            if (usernameed.text.toString().trim().isEmpty() || passworded.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Input Required", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Client Logging In...", Toast.LENGTH_SHORT).show()

            }
            val Intent = Intent(this,Home::class.java)
            startActivity(Intent)
        }
    }
}