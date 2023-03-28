package com.android.project.di

import com.android.project.provider.DataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//lo que inyecto en la clase solo existe en una instancia
class ProviderModule {
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://restapi-e5ed3-default-rtdb.firebaseio.com/".toHttpUrl()//inyectar url

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: HttpUrl): Retrofit {//inyectar url
        return Retrofit.Builder()
            //convertir el json de la api
            .addConverterFactory(GsonConverterFactory.create())
            //url de la api
            .baseUrl(baseUrl)
            .build()//construir retrofit
    }

    @Provides
    @Singleton
    fun providerDataProvider(retrofit: Retrofit): DataProvider =
        retrofit.create(DataProvider::class.java)//instancia de retrofit, regresa un newsprovider

}