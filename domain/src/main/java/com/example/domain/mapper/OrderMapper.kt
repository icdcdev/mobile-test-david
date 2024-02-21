package com.example.domain.mapper

import com.example.localdata.entities.OrderEntity
import com.example.models.Order
import com.example.remotedata.orders.response.OrderResponse

fun OrderEntity.toModel(): Order = Order(
    orderId = this.orderId,
    serviceTypeId = this.serviceTypeId,
    serviceType = this.serviceType,
    model = this.model,
    startTime = this.startTime,
    plates = this.plates,
    pyramidColor = this.pyramidColor,
    pyramidNumber = this.pyramidNumber,
    orderStatus = this.orderStatus,
    orderStatusId = this.orderStatusId,
    hasFile = this.hasFile,
    urlFile = this.urlFile,
)

fun Order.toEntity(): OrderEntity =
    OrderEntity(
        orderId = this.orderId,
        serviceTypeId = this.serviceTypeId,
        serviceType = this.serviceType,
        model = this.model,
        startTime = this.startTime,
        plates = this.plates,
        pyramidColor = this.pyramidColor,
        pyramidNumber = this.pyramidNumber,
        orderStatus = this.orderStatus,
        orderStatusId = this.orderStatusId,
        hasFile = this.hasFile,
        isAssigned = false,
        urlFile = this.urlFile,
    )

fun OrderResponse.toModel(): Order =
    Order(
        orderId = this.orderId!!,
        serviceTypeId = this.serviceTypeId,
        serviceType = this.serviceType,
        model = this.model,
        startTime = this.startTime,
        plates = this.plates,
        pyramidColor = this.pyramidColor,
        pyramidNumber = this.pyramidNumber,
        orderStatus = this.orderStatus,
        orderStatusId = this.orderStatusId,
        hasFile = false,
        urlFile = ""
    )