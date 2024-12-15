package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.databinding.ActivityMainBinding
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.model.Destination
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.ui.adapter.DestinationAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val destinationList = listOf(
        Destination("Bali", "Pulau indah di Indonesia."),
        Destination("Yogyakarta", "Kota budaya dan sejarah."),
        Destination("Jakarta", "Ibu kota Indonesia."),
        Destination("Lombok", "Pulau dengan pantai yang cantik."),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = DestinationAdapter(destinationList) { destination ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("destinationName", destination.name)
            intent.putExtra("description", destination.description)
            startActivity(intent)
        }
        binding.rvDestinations.layoutManager = LinearLayoutManager(this)
        binding.rvDestinations.adapter = adapter

        binding.btnWishlist.setOnClickListener {
            startActivity(Intent(this, WishlistActivity::class.java))
        }
    }
}
