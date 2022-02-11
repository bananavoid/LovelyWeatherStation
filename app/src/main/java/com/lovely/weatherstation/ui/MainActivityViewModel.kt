package com.lovely.weatherstation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lovely.weatherstation.datasource.Repository

class MainActivityViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _cityForecasts = MutableLiveData<List<CityWeatherViewModel>>().apply {
        postValue(
            repository.getFavoriteCities().map { city ->
                CityWeatherViewModel(
                    cityName = city.name,
                    cityWoeid = city.woeid,
                    repository = repository
                )
            }
        )
    }
    val cityForecasts: LiveData<List<CityWeatherViewModel>> = _cityForecasts
}