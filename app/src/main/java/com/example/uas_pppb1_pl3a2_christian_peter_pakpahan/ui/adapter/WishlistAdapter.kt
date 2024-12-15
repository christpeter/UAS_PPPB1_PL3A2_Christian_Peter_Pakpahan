package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.WishlistItem
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.databinding.ItemWishlistBinding

class WishlistAdapter(
    private val onDeleteClick: (WishlistItem) -> Unit
) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    private val items = mutableListOf<WishlistItem>()

    fun submitList(newItems: List<WishlistItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemWishlistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlistItem: WishlistItem) {
            binding.tvDestinationName.text = wishlistItem.destinationName
            binding.tvDescription.text = wishlistItem.description
            binding.btnDelete.setOnClickListener {
                onDeleteClick(wishlistItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWishlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}