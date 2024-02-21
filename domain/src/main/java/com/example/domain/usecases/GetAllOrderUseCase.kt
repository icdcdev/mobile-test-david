package com.example.domain.usecases

import com.example.domain.repository.OrderRepository
import com.example.models.Order
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IGetAllOrderUseCase {
    fun invoke(isAssigned: Boolean): Flow<List<Order>>
}

class GetAllOrderUseCase @Inject constructor(private val orderRepository: OrderRepository) :
    IGetAllOrderUseCase {
    override fun invoke(isAssigned: Boolean): Flow<List<Order>> =
        orderRepository.getAllOrdersRepository(isAssigned = isAssigned)
}