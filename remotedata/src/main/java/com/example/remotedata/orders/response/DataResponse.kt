package com.example.remotedata.orders.response

import com.squareup.moshi.Json

data class DataResponse(@Json(name="message" ) var message : String? = null,
                        @Json(name="data"    ) var data    : List<OrderResponse> = arrayListOf())
