package com.example.ecdcchallange.orders

import com.example.models.Order

sealed class ViewSateOrder{
    object Loading : ViewSateOrder()
    class ErrorLoadingItems(val error: String) : ViewSateOrder()
    object NotFoundItems : ViewSateOrder()
    class ItemOrder(val orders: List<Order>) : ViewSateOrder()
}
