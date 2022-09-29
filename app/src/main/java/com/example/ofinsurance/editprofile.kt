package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class editprofile : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_editprofile, container, false)
        val save: Button = view.findViewById(R.id.btnsave)
        save.setOnClickListener {
            Toast.makeText(activity, "successfully Saved", Toast.LENGTH_SHORT).show()
            val fragment = Settings()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.editprofile, fragment)?.commit()
            save.visibility = View.GONE

        }
        return view
    }

}