
package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isGone
import androidx.core.view.isInvisible

class Owned : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_owned, container, false)
        val pay : Button = view.findViewById(R.id.paybtn1)
        val pay2 : Button = view.findViewById(R.id.paybtn2)
        pay.setOnClickListener{
            val fragment = OwnedBill()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.own,fragment)?.commit()
            pay.visibility = View.GONE
            pay2.visibility = View.GONE
        }

        pay2.setOnClickListener{
            val fragment = OwnedBill()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.own,fragment)?.commit()
            pay2.visibility = View.GONE
            pay.visibility = View.GONE
        }
        return view
    }
}