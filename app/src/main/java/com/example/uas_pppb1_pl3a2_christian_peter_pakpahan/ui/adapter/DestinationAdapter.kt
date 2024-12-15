package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.databinding.ItemDestinationBinding
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.model.Destination

class DestinationAdapter(
    private val items: List<Destination>,
    private val onItemClick: (Destination) -> Unit
) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemDestinationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(destination: Destination) {
            binding.tvDestinationName.text = destination.name
            binding.root.setOnClickListener {
                onItemClick(destination)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDestinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}