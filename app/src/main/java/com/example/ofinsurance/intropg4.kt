package com.example.ofinsurance

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.ofinsurance.databinding.FragmentFourthBinding

class intropg4 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = FragmentFourthBinding.inflate(layoutInflater)
        view.loginregbtn.setOnClickListener{
            val intent = Intent (this@intropg4.requireContext(),LoginActivity::class.java)
            startActivity(intent)
        }

        return view.root
    }
}