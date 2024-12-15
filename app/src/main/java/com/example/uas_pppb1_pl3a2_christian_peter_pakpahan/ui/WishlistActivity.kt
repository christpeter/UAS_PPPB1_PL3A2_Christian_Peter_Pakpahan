package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.WishlistDatabase
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.databinding.ActivityWishlistBinding
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.ui.adapter.WishlistAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WishlistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWishlistBinding
    private lateinit var adapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WishlistAdapter { wishlistItem ->
            deleteWishlistItem(wishlistItem.id)
        }
        binding.rvWishlist.layoutManager = LinearLayoutManager(this)
        binding.rvWishlist.adapter = adapter

        loadWishlistItems()
    }

    private fun loadWishlistItems() {
        lifecycleScope.launch(Dispatchers.IO) {
            val wishlistItems = WishlistDatabase.getInstance(this@WishlistActivity).wishlistDao().getAllWishlistItems()
            withContext(Dispatchers.Main) {
                adapter.submitList(wishlistItems)
            }
        }
    }

    private fun deleteWishlistItem(id: Int) {
        lifecycleScope.launch(Dispatchers.IO) {
            WishlistDatabase.getInstance(this@WishlistActivity).wishlistDao().deleteWishlistItemById(id)
            loadWishlistItems()
        }
    }
}