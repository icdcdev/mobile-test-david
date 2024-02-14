package com.example.remotedata.di

import com.example.remotedata.api.VolksWagenApi
import com.example.remotedata.orders.OrderRemoteDataSource
import com.example.remotedata.orders.OrderRemoteDataSourceImple
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.Date
import javax.inject.Singleton

class RemoteModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideMarvelApi(okHttpClient: OkHttpClient): VolksWagenApi {
        val moshi = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl("https://5a5q7x88fb.execute-api.us-west-2.amazonaws.com")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(VolksWagenApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOrderRemoteDataSource(
        volksWagenApi: VolksWagenApi
    ): OrderRemoteDataSource {
        return OrderRemoteDataSourceImple(
            volksWagenApi
        )
    }
}