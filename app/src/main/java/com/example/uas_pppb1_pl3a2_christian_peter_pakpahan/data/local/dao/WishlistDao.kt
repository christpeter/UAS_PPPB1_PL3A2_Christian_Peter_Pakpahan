package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.entity.WishlistItem
import retrofit2.http.Query

@Dao
interface WishlistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(wishlistItem: WishlistItem)

    @Query("SELECT * FROM wishlist_table")
    fun getAllWishlistItems(): LiveData<List<WishlistItem>>

    @Delete
    suspend fun delete(wishlistItem: WishlistItem)
}
