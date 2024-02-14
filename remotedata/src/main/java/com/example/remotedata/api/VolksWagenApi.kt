package com.example.remotedata.api

import com.example.remotedata.orders.response.DataResponse
import retrofit2.http.GET
interface VolksWagenApi {
    @GET("/orders")
    suspend fun getOrders(): DataResponse
}