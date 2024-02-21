package com.example.domain.di

import com.example.domain.repository.OfflineFirstOrderRepository
import com.example.domain.repository.OrderRepository
import com.example.domain.usecases.GetAllOrderUseCase
import com.example.domain.usecases.IGetAllOrderUseCase
import com.example.domain.usecases.ISyncOrderUseCase
import com.example.domain.usecases.IUpdateAssinedOrderUseCase
import com.example.domain.usecases.SyncOrderUseCase
import com.example.domain.usecases.UpdateAssinedOrderUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    fun providerAllOrderUseCase(getAllOrderUseCase: GetAllOrderUseCase): IGetAllOrderUseCase

    @Binds
    fun providerUpdateAssinedOrderUseCase(updateAssinedOrderUseCase: UpdateAssinedOrderUseCase): IUpdateAssinedOrderUseCase

    @Binds
    fun providerSyncOrderUseCase(syncOrderUseCase: SyncOrderUseCase): ISyncOrderUseCase

    @Binds
    fun providerOrderRepository(orderRepository: OfflineFirstOrderRepository): OrderRepository

}