package com.example.domain.repository

import com.example.domain.mapper.toModel
import com.example.localdata.dao.OrderDao
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstOrderRepository @Inject constructor(val orderDao: OrderDao) : OrderRepository {
    override fun getAllOrdersRepository(isAssigned: Boolean) =
        orderDao.getOrders(isAssigned = isAssigned).map { it.map { it.toModel() } }
}