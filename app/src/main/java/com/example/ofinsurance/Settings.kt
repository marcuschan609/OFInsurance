package com.example.ofinsurance

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class Settings: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        val edit: Button = view.findViewById(R.id.btnedit)
        val email: Button = view.findViewById(R.id.btnverify)
        val signout: Button = view.findViewById(R.id.btnsignout)

        edit.setOnClickListener {
            val fragment = editprofile()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.settings, fragment)?.commit()
            edit.visibility = View.GONE
            email.visibility = View.GONE
        }

        email.setOnClickListener {
            val fragment = emailverify()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.settings, fragment)?.commit()
            email.visibility = View.GONE
            edit.visibility = View.GONE
        }

        signout.setOnClickListener {

            Toast.makeText(activity, "Signed Out!", Toast.LENGTH_SHORT).show()
            val intent = Intent (activity,LoginActivity::class.java)
            startActivity(intent)

            edit.visibility = View.GONE
            email.visibility = View.GONE
        }



        return view
    }

}