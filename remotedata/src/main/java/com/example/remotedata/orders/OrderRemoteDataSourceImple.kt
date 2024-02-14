package com.example.remotedata.orders

import com.example.remotedata.api.VolksWagenApi
import com.example.remotedata.common.MapResultError.safeApiCall
import com.example.remotedata.common.NetworkResult
import com.example.remotedata.orders.response.DataResponse
import javax.inject.Inject

class OrderRemoteDataSourceImple @Inject constructor(val volksWagenApi: VolksWagenApi) :
    OrderRemoteDataSource {
    override suspend fun getAllOrders(): NetworkResult<DataResponse> =
        safeApiCall {
            volksWagenApi.getOrders()
        }
}