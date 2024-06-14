package com.example.houseonpalm.ui.brokers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.houseonpalm.R
import com.example.houseonpalm.models.Listing

class ListingAdapter(
    private var listings: List<Listing>,
    private val onItemClick: (Listing) -> Unit
) : RecyclerView.Adapter<ListingAdapter.ListingViewHolder>() {

    class ListingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listingImageView: ImageView = itemView.findViewById(R.id.listingImageView)
        val listingPriceTextView: TextView = itemView.findViewById(R.id.listingPriceTextView)
        val listingAddressTextView: TextView = itemView.findViewById(R.id.listingAddressTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listing, parent, false)
        return ListingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        val listing = listings[position]
        holder.listingPriceTextView.text = "$${listing.price}"
        holder.listingAddressTextView.text = listing.address
        Glide.with(holder.itemView.context)
            .load(listing.imageUrl)
            .into(holder.listingImageView)

        holder.itemView.setOnClickListener {
            onItemClick(listing)
        }
    }

    override fun getItemCount(): Int {
        return listings.size
    }

    fun updateList(newList: List<Listing>) {
        listings = newList
        notifyDataSetChanged()
    }
}
