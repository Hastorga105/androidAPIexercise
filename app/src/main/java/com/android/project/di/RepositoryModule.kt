package com.android.project.di

import com.android.project.provider.DataProvider
import com.android.project.repository.DataRepository
import com.android.project.repository.DataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providerDataRepository(provider: DataProvider): DataRepository =
        DataRepositoryImp(provider)
}