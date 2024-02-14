package com.example.remotedata.orders.response

import com.squareup.moshi.Json

data class OrderResponse(
    @Json(name = "orderId") var orderId: String? = null,
    @Json(name = "serviceTypeId") var serviceTypeId: Int? = null,
    @Json(name = "serviceType") var serviceType: String? = null,
    @Json(name = "model") var model: String? = null,
    @Json(name = "startTime") var startTime: String? = null,
    @Json(name = "plates") var plates: String? = null,
    @Json(name = "pyramidColor") var pyramidColor: String? = null,
    @Json(name = "pyramidNumber") var pyramidNumber: Int? = null,
    @Json(name = "orderStatusId") var orderStatusId: Int? = null,
    @Json(name = "orderStatus") var orderStatus: String? = null
)
