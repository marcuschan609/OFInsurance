package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.ofinsurance.databinding.ActivityMainBinding


class payment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_payment, container, false)
        val pay : Button = view.findViewById(R.id.btnsubmit)
        pay.setOnClickListener{
            val fragment = payment2()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.payment,fragment)?.commit()
        }
        return view
    }
}