package com.android.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.project.model.News
import com.android.project.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel(){
    private val _news = MutableLiveData<List<News>>()//Lista de noticias

    fun getNews(): LiveData<List<News>>{ //regresa un livedata como lista de news
        viewModelScope.launch(Dispatchers.IO){
            val news = repository.getNews("US")  //obtener news del repositorio, solo de us
            _news.postValue(news)  //pasar datos a livedata
        }
        return _news

    }

}