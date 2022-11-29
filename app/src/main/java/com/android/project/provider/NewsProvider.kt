package com.android.project.provider

import com.android.project.model.NewApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "f28e6a9090af47e39fd19b37d9cecc54"
//Llamar a la rest api
interface NewsProvider {
    @GET("main.json")
    suspend fun topHeadLines(@Query("country")country: String): Response<NewApiResponse>

}