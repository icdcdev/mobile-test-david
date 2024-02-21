package com.example.domain.usecases

import com.example.domain.repository.OrderRepository
import com.example.models.Order
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IUpdateAssinedOrderUseCase {
    suspend fun invoke(isAssigned: Boolean, orderId: String): Long
}

class UpdateAssinedOrderUseCase @Inject constructor(private val orderRepository: OrderRepository) :
    IUpdateAssinedOrderUseCase {
    override suspend fun invoke(isAssigned: Boolean, orderId: String): Long =
        orderRepository.updateOrder(isAssigned = isAssigned, orderId = orderId)
}