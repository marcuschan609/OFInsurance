package com.example.ofinsurance.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.ofinsurance.Models.User
import com.example.ofinsurance.R

class Myadapter : RecyclerView.Adapter<Myadapter.MyViewholder>() {

  private val userList = ArrayList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
            parent,false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = userList[position]

        holder.firstName.text = currentitem.firstName
        holder.lastName.text = currentitem.lastName
        holder.age.text = currentitem.age
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(userList: List<User>){

        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()

    }
}


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val firstName : TextView = itemView.findViewById(R.id.tvfirstName)
        val lastName : TextView = itemView.findViewById(R.id.tvlastName)
        val age : TextView = itemView.findViewById(R.id.tvage)

}