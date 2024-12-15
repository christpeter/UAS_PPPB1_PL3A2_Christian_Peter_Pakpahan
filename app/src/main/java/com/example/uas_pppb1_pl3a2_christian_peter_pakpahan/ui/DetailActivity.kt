package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.WishlistDatabase
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.WishlistItem
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.entity.WishlistItem
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.databinding.ActivityDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val destinationName = intent.getStringExtra("destinationName") ?: ""
        val description = intent.getStringExtra("description") ?: ""

        binding.tvDestinationName.text = destinationName
        binding.tvDescription.text = description

        binding.btnAddToWishlist.setOnClickListener {
            val wishlistItem = WishlistItem(destinationName = destinationName, description = description)
            CoroutineScope(Dispatchers.IO).launch {
                WishlistDatabase.getInstance(this@DetailActivity).wishlistDao().insertWishlistItem(wishlistItem)
            }
            Toast.makeText(this, "Ditambahkan ke Wishlist!", Toast.LENGTH_SHORT).show()
        }

        binding.btnOrderTicket.setOnClickListener {
            Toast.makeText(this, "Tiket berhasil dipesan!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}