package com.example.remotedata.orders

import com.example.remotedata.common.NetworkResult
import com.example.remotedata.orders.response.DataResponse

interface OrderRemoteDataSource {
    suspend fun getAllOrders() : NetworkResult<DataResponse>

}