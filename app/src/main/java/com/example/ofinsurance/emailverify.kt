package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class emailverify : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_emailverify, container, false)
        val send: Button = view.findViewById(R.id.btnsend)
        send.setOnClickListener {
            Toast.makeText(activity, "successfully Sent", Toast.LENGTH_SHORT).show()
            val fragment = Settings()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.emailverify, fragment)?.commit()
            send.visibility = View.GONE

        }
        return view
    }

}