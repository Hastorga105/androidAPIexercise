package com.android.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.project.model.Data
import com.android.project.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repository: DataRepository
): ViewModel(){
    private val _data = MutableLiveData<List<Data>>()//Lista de datos

    fun getNews(): LiveData<List<Data>>{ //regresa un livedata como lista de data
        viewModelScope.launch(Dispatchers.IO){
            val news = repository.getData()  //obtener datos del repositorio, solo de us
            _data.postValue(news)  //pasar datos a livedata
        }
        return _data

    }

}