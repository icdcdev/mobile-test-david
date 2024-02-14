package com.example.models

data class Order(var orderId: String,
                 var serviceTypeId: Int?,
                 var serviceType: String?,
                 var model: String?,
                 var startTime: String?,
                 var plates: String?,
                 var pyramidColor: String?,
                 var pyramidNumber: Int?,
                 var orderStatusId: Int?,
                 var orderStatus: String?,
                 var hasFile: Boolean,
                 var urlFile: String?)