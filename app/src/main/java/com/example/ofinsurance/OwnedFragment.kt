
package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class OwnedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_owned, container, false)
        val pay : Button = view.findViewById(R.id.paybtn1)
        pay.setOnClickListener{
            val fragment = OwnedBillFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.own,fragment)?.commit()
        }
        return view
    }
}