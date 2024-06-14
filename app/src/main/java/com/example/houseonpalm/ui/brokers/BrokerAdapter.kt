package com.example.houseonpalm.ui.brokers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.houseonpalm.R

class BrokerAdapter(
    private var brokers: List<Broker>,
    private val onItemClicked: (Broker) -> Unit
) : RecyclerView.Adapter<BrokerAdapter.BrokerViewHolder>() {

    class BrokerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brokerNameTextView: TextView = itemView.findViewById(R.id.brokerNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrokerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.broker_item, parent, false)
        return BrokerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrokerViewHolder, position: Int) {
        val broker = brokers[position]
        holder.brokerNameTextView.text = broker.name
        holder.itemView.setOnClickListener {
            onItemClicked(broker)
        }
    }

    override fun getItemCount(): Int {
        return brokers.size
    }

    fun updateList(newList: List<Broker>) {
        brokers = newList
        notifyDataSetChanged()
    }
}
