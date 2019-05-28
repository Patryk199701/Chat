package com.example.chat

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*




class RecyclerAdapter(private val clickListener: (Message) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var messageList : MutableList<Message> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item ,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(messageList[position], clickListener)
    }

    fun setMessageListItems(messageList: MutableList<Message>){
        this.messageList = messageList
        notifyDataSetChanged()
    }




    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: Message, clickListener: (Message) -> Unit) {
            itemView.messageContent.text = item.content
            itemView.userNick.text = item.login
            itemView.date.text = item.date
            itemView.setOnClickListener { clickListener(item)}
        }
    }
}