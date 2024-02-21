package com.example.ecdcchallange.orders

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetAllOrderUseCase
import com.example.domain.usecases.IGetAllOrderUseCase
import com.example.domain.usecases.ISyncOrderUseCase
import com.example.domain.usecases.SyncOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val syncOrderUseCase: ISyncOrderUseCase,
    private val getAllOrderUseCase: IGetAllOrderUseCase
) :
    ViewModel(), LifecycleObserver {

    private val _viewStateOrder = MutableLiveData<ViewSateOrder>()
    fun getViewStateOrder() = _viewStateOrder

    fun fetchOrders(isAssigned: Boolean) {
        viewModelScope.launch {
            async { syncOrderUseCase.invoke() }.await()
            try {
                getAllOrderUseCase.invoke(isAssigned)
                    .onStart { _viewStateOrder.value = ViewSateOrder.Loading }
                    .catch {
                        _viewStateOrder.value =
                            ViewSateOrder.ErrorLoadingItems(it.message ?: "Unknown error")
                    }
                    .collect {
                        if (it.isEmpty()) {
                            _viewStateOrder.value = ViewSateOrder.NotFoundItems
                        } else {
                            _viewStateOrder.value = ViewSateOrder.ItemOrder(orders = it)
                        }
                    }
            } catch (exception: Exception) {
                _viewStateOrder.value =
                    ViewSateOrder.ErrorLoadingItems(exception.message ?: "Unknown error")
            }
        }
    }
}