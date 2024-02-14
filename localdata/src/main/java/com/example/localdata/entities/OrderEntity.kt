package com.example.localdata.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "order"
)
data class OrderEntity(
    @PrimaryKey(autoGenerate = false) var orderId: String,
    var serviceTypeId: Int?,
    var serviceType: String?,
    var model: String?,
    var startTime: String?,
    var plates: String?,
    var pyramidColor: String?,
    var pyramidNumber: Int?,
    var orderStatusId: Int?,
    var orderStatus: String?,
    var isAssigned: Boolean,
    var hasFile: Boolean,
    var urlFile: String?
)