package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishlist_table")
data class WishlistItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val destinationName: String,
    val description: String
)