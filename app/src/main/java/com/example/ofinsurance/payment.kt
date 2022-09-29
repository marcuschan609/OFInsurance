package com.example.ofinsurance

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import com.example.ofinsurance.databinding.ActivityMainBinding


class payment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_payment, container, false)
        val credit : Button = view.findViewById(R.id.btncredit)
        val debit : Button = view.findViewById(R.id.btndebit)
        val online : Button = view.findViewById(R.id.btnonline)
        val ewallet : Button = view.findViewById(R.id.btnewallet)

        credit.setOnClickListener {
            val fragment = creditcard()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.payment, fragment)?.commit()
            credit.visibility = View.GONE
            debit.visibility = View.GONE
            online.visibility = View.GONE
            ewallet.visibility = View.GONE
        }

            debit.setOnClickListener {
                val fragment = debitcard()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.payment, fragment)?.commit()
                credit.visibility = View.GONE
                debit.visibility = View.GONE
                online.visibility = View.GONE
                ewallet.visibility = View.GONE
            }

                online.setOnClickListener {
                    val fragment = onlinebanking()
                    val transaction = fragmentManager?.beginTransaction()
                    transaction?.replace(R.id.payment, fragment)?.commit()
                    credit.visibility = View.GONE
                    debit.visibility = View.GONE
                    online.visibility = View.GONE
                    ewallet.visibility = View.GONE
                }

                    ewallet.setOnClickListener {
                        val fragment = com.example.ofinsurance.ewallet()
                        val transaction = fragmentManager?.beginTransaction()
                        transaction?.replace(R.id.payment, fragment)?.commit()
                        credit.visibility = View.GONE
                        debit.visibility = View.GONE
                        online.visibility = View.GONE
                        ewallet.visibility = View.GONE

                    }
                    return view

                }
            }