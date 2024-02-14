package com.example.localdata

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.localdata.dao.OrderDao
import com.example.localdata.entities.OrderEntity

@Database(
    entities = [
        OrderEntity::class,
    ],
    version = 1,exportSchema = true
)
abstract class AdsDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}