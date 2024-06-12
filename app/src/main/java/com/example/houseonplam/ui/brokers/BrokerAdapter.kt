package com.example.houseonplam.ui.brokers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.houseonplam.R

class BrokerAdapter(private var brokers: List<Broker>) : RecyclerView.Adapter<BrokerAdapter.BrokerViewHolder>() {

    class BrokerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brokerNameTextView: TextView = itemView.findViewById(R.id.brokerNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrokerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.broker_item, parent, false)
        return BrokerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrokerViewHolder, position: Int) {
        holder.brokerNameTextView.text = brokers[position].name
    }

    override fun getItemCount(): Int {
        return brokers.size
    }

    fun updateList(newList: List<Broker>) {
        brokers = newList
        notifyDataSetChanged()
    }
}
