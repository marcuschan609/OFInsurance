package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class intropg3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val next : Button = view.findViewById(R.id.next2btn)
        next.setOnClickListener{
            val fragment = intropg4()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_intro,fragment)?.commit()
        }
        return view
    }
}