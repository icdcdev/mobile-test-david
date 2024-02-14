package com.example.localdata.di

import android.content.Context
import androidx.room.Room
import com.example.localdata.AdsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context,
    ): AdsDatabase = Room.databaseBuilder(
        context,
        AdsDatabase::class.java,
        "marvel-database",
    ).fallbackToDestructiveMigration().build()
}