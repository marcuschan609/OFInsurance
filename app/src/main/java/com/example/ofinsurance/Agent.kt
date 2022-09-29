package com.example.ofinsurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ofinsurance.Adapter.Myadapter
import com.example.ofinsurance.Models.UserViewModel


private lateinit var viewmodel : UserViewModel
private  lateinit var userRecyclerView: RecyclerView
lateinit var  adapter: MyAdapter

class Agent : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRecyclerView = view.findViewById(R.id.recyclerview)
        userRecyclerView.layoutManager = LinearLayoutManager(context)
        userRecyclerView.setHasFixedSize(true)
        adapter = MyAdapter()
        userRecyclerView.adapter = adapter

        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewmodel.allUsers.observe(viewLifecycleOwner, Observer{

            adapter.updateUserList(it)

        })

    }
}
