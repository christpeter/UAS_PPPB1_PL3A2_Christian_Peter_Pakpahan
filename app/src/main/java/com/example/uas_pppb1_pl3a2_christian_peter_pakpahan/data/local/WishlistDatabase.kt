package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.dao.WishlistDao
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.data.local.entity.WishlistItem

@Database(entities = [WishlistItem::class], version = 1, exportSchema = false)
abstract class WishlistDatabase : RoomDatabase() {

    abstract fun wishlistDao(): WishlistDao

    companion object {
        @Volatile
        private var INSTANCE: WishlistDatabase? = null

        fun getDatabase(context: Context): WishlistDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WishlistDatabase::class.java,
                    "wishlist_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}