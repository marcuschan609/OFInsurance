package com.example.ofinsurance

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ofinsurance.data.User
import com.example.ofinsurance.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.components.Dependency.required
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()
        usernameFocusListener()
        passwordFocusListener()
        confirmpasswordFocusListener()

        firebaseAuth = FirebaseAuth.getInstance()

        binding.backtologintv.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.registerbtn.setOnClickListener {
            val username = binding.usernameed.text.toString()
            val email = binding.emailed.text.toString()
            val pass = binding.passed.text.toString()
            val confirmPass = binding.repassed.text.toString()

            registerForm()
            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(username, email, pass, confirmPass)

            if (username.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if ((pass == confirmPass)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            database.child(username).setValue(User).addOnSuccessListener {
                                binding.usernameed.text?.clear()
                                binding.emailed.text?.clear()
                                binding.passed.text?.clear()
                                binding.repassed.text?.clear()
                                Toast.makeText(
                                    this,
                                    "Account Registered, proceed to Login",
                                    Toast.LENGTH_LONG
                                ).show()
                                //val intent = Intent(this, LoginActivity::class.java)
                                //startActivity(intent)
                            }
                        } else {
                            Toast.makeText(this, "Email already registered", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                } else {
                    Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    //username validator
    private fun usernameFocusListener() {
        binding.usernameed.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.usernametv.helperText = validUsername()
            }
        }
    }

    private fun validUsername(): String? {
        val usernameed = binding.usernameed.text.toString()
        if (usernameed.length>6){
            return "Maximum 6 Character Username"
        }
        if (usernameed.length<3){
            return "Minimum 3 Character Username"
        }
        if (usernameed.matches(".*[A-Z].*".toRegex())){
            return "Only Lower-case Characters or Numbers"
        }
        if (usernameed.matches(".*[@#\$%^&+=].*".toRegex())){
            return "Only Lower-case Characters or Numbers"
        }
        if (usernameed.matches(".*[ ].*".toRegex())){
            return "No Spacing Allowed in Username"
        }
        return null
    }

    //email validator
    private fun emailFocusListener() {
        binding.emailed.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailtv.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailed = binding.emailed.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailed).matches()) {
            return "Invalid Email Address"
        }
        return null
    }


    //password validator
    private fun passwordFocusListener() {
        binding.passed.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passtv.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passed = binding.passed.text.toString()
        if (passed.length<6){
            return "Minimum 6 Character Password"
        }
        if (!passed.matches(".*[A-Z].*".toRegex())){
            return "Must Contain 1 Upper-case Character"
        }
        if (!passed.matches(".*[a-z].*".toRegex())){
            return "Must Contain 1 Lower-case Character"
        }
        if (passed.matches(".*[ ].*".toRegex())){
            return "No Spacing Allowed in Password"
        }
        return null
    }

    //confirm password validator
    private fun confirmpasswordFocusListener() {
        binding.repassed.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.repasstv.helperText = validConfirmPassword()
            }
        }
    }

    private fun validConfirmPassword(): String? {
        val repassed = binding.repassed.text.toString()
        if (repassed != binding.passed.text.toString()){
            return "Password Does Not Match"
        }
        return null
    }

    //register form to double check details
    private fun registerForm()
    {
        binding.usernametv.helperText = validUsername()
        binding.emailtv.helperText = validEmail()
        binding.passtv.helperText = validPassword()

        val validEmail = binding.emailtv.helperText == null
        val validPassword = binding.passtv.helperText == null
        val validUsername = binding.usernametv.helperText == null

        if (validEmail && validPassword && validUsername)
            resetForm()
        else
            invalidForm()
    }

    private fun invalidForm()
    {
        var message = ""
        if(binding.usernametv.helperText != null)
            message += "\n\nUsername: " + binding.usernametv.helperText
        if(binding.emailtv.helperText != null)
            message += "\n\nEmail: " + binding.emailtv.helperText
        if(binding.passtv.helperText != null)
            message += "\n\nPassword: " + binding.passtv.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Details Given")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                // do nothing
            }
            .show()
    }

    private fun resetForm()
    {
        var message = "Username: " + binding.usernameed.text
        message += "\nEmail: " + binding.emailed.text
        message += "\nPassword: " + binding.passed.text

        AlertDialog.Builder(this)
            .setTitle("Account Registered")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->

                binding.emailtv.helperText = null
                binding.passtv.helperText = null
                binding.repasstv.helperText = null
                binding.usernametv.helperText = null
            }
            .show()
    }
}