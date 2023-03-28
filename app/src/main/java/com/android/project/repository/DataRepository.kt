package com.android.project.repository

import com.android.project.model.Data
import com.android.project.provider.DataProvider
import javax.inject.Inject

interface DataRepository {
    suspend fun getData(): List<Data>
    fun getData(title: String): Data
}

class DataRepositoryImp @Inject constructor(
    private val newsProvider: DataProvider//Inyectamos el provider en el repositorio
): DataRepository{

    private var data: List<Data> = emptyList()//Aqui se van a guardar los datos de la api

    override suspend fun getData(/*country: String*/): List<Data> {
        //Llamar a la funcion que regresa la respuesta de la api (topheadlines)
        val apiResponse = newsProvider.obtenerDatos().body()
        /*if (apiResponse?.status == "error") {
            when (apiResponse.code) {
                "apiKeyMissing" -> throw MissingApiKeyException()
                "apiKeyInvalid" -> throw ApiKeyInvalidException()
                else -> throw Exception()
            }
        }*/
        data = apiResponse?.articles ?: emptyList()
        return data
    }
    override fun getData(title: String): Data =
        data.first { it.title == title }//revisar si el titulo es igual
}
/*
class MissingApiKeyException : java.lang.Exception()
class ApiKeyInvalidException : java.lang.Exception()
*/

