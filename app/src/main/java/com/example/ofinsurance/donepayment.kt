package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.ofinsurance.databinding.ActivityMainBinding


class donepayment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_donepayment, container, false)
        val close : Button = view.findViewById(R.id.btnclose)
        close.setOnClickListener{
            val fragment = Owned()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.donepayment,fragment)?.commit()
            close.visibility = View.GONE

        }


        return view
    }
}
