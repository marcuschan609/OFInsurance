package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class onlinebanking: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onlinebanking, container, false)
        val proceed : Button = view.findViewById(R.id.btnproceed)
        proceed.setOnClickListener{
            val fragment = donepayment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.online,fragment)?.commit()
            proceed.visibility = View.GONE

        }


        return view
    }
}