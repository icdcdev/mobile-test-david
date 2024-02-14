package com.example.domain.repository

import com.example.models.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getAllOrdersRepository(isAssigned: Boolean): Flow<List<Order>>
}