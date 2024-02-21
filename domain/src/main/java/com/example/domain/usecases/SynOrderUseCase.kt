package com.example.domain.usecases

import com.example.domain.repository.OrderRepository
import com.example.models.Order
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ISyncOrderUseCase {
    suspend fun invoke()
}

class SyncOrderUseCase @Inject constructor(private val orderRepository: OrderRepository) :
    ISyncOrderUseCase {
    override suspend fun invoke() =
        orderRepository.syncOrder()
}