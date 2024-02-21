package com.example.localdata.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.localdata.entities.OrderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Upsert
    suspend fun upsertAll(comics: List<OrderEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(comic: List<OrderEntity>)

    @Query("SELECT * FROM `order` WHERE isAssigned= :isAssigned")
    fun getOrders(isAssigned: Boolean): Flow<List<OrderEntity>>

    @Query("UPDATE `order` SET isAssigned = :isAssigned WHERE orderId= :orderId")
    fun updateOrder(orderId: String, isAssigned: Boolean): Long

    @Query("DELETE FROM `order`")
    suspend fun clearAll()

}