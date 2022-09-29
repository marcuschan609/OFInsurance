package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class OwnedBill : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_owned_bill, container, false)
        val pay3 : Button = view.findViewById(R.id.btnPayNow)
        pay3.setOnClickListener{
            val fragment = payment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.ownedbill,fragment)?.commit()
            pay3.visibility = View.GONE

        }


        return view
    }
}
