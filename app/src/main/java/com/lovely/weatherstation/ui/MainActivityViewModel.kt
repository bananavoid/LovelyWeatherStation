package com.lovely.weatherstation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lovely.weatherstation.datasource.Repository
import com.lovely.weatherstation.datasource.model.City

class MainActivityViewModel(
    internal val repository: Repository
) : ViewModel() {

    private val _cities = MutableLiveData<List<City>>().apply {
        postValue(
            repository.getFavoriteCities()
        )
    }
    val cities: LiveData<List<City>> = _cities
}