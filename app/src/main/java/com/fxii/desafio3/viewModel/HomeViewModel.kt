package com.fxii.desafio3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fxii.desafio3.business.ComicsBusiness
import com.fxii.desafio3.model.Comics
import com.fxii.desafio3.model.Result
import com.fxii.desafio3.services.ResponseMarvel
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val comicsLiveData: MutableLiveData<List<Result>> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    val comicsBusiness = ComicsBusiness()

    fun getComics() {
        viewModelScope.launch {
            val comics = comicsBusiness.getComics()
            if(comics is ResponseMarvel.Success) {
                val response = comics.data as? Comics
                comicsLiveData.postValue(response?.data?.results)
            }
            else {
                comics as ResponseMarvel.Error
                errorLiveData.postValue(comics.message)
            }

        }
    }
}