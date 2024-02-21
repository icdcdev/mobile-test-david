package com.example.domain.repository

import com.example.domain.mapper.toEntity
import com.example.domain.mapper.toModel
import com.example.localdata.dao.OrderDao
import com.example.remotedata.common.NetworkResult
import com.example.remotedata.orders.OrderRemoteDataSource
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstOrderRepository @Inject constructor(
    val orderDao: OrderDao,
    val remoteDataSource: OrderRemoteDataSource
) : OrderRepository {
    override fun getAllOrdersRepository(isAssigned: Boolean) =
        orderDao.getOrders(isAssigned = isAssigned).map { it.map { it.toModel() } }

    override suspend fun updateOrder(isAssigned: Boolean, orderId: String): Long =
        orderDao.updateOrder(orderId = orderId, isAssigned = isAssigned)

    override suspend fun syncOrder() {
        when (val response = remoteDataSource.getAllOrders()) {
            is NetworkResult.NetWorkSuccess -> {
                orderDao.insertOrder(response.result.data.map {
                    it.toModel().toEntity()
                })
            }
            else -> {}
        }
    }
}