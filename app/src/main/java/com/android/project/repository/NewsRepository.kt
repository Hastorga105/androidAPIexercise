package com.android.project.repository

import com.android.project.model.News
import com.android.project.provider.NewsProvider
import javax.inject.Inject

interface NewsRepository {
    suspend fun getNews(country: String): List<News>
    fun getNew(title: String): News

}

class NewsRepositoryImp @Inject constructor(
    private val newsProvider: NewsProvider//Inyectamos el provider en el repositorio
): NewsRepository{

    private var news: List<News> = emptyList()//Aqui se van a guardar los datos de la api

    override suspend fun getNews(country: String): List<News> {
        //Llamar a la funcion que regresa la respuesta de la api (topheadlines)
        val apiResponse = newsProvider.topHeadLines(country).body()
        if (apiResponse?.status == "error") {
            when (apiResponse.code) {
                "apiKeyMissing" -> throw MissingApiKeyException()
                "apiKeyInvalid" -> throw ApiKeyInvalidException()
                else -> throw Exception()
            }
        }
        news = apiResponse?.articles ?: emptyList()
        return news
    }
    override fun getNew(title: String): News =
        news.first { it.title == title }//revisar si el titulo es igual
}
class MissingApiKeyException : java.lang.Exception()
class ApiKeyInvalidException : java.lang.Exception()


