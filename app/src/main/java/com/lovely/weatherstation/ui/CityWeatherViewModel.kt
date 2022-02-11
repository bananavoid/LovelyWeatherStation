package com.lovely.weatherstation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lovely.weatherstation.datasource.Repository
import kotlinx.coroutines.Dispatchers

class CityWeatherViewModel(
    cityName: String,
    private val cityWoeid: Long,
    private val repository: Repository
) : ViewModel() {

    val name: LiveData<String> = MutableLiveData(cityName)
    private val _weatherForecast = liveData(Dispatchers.IO) {
        try {
            emit(
                repository.getWeatherForLocation(cityWoeid)[1]
            )
        } catch (e: Exception) {
            Log.e("CityWeatherViewModel", "$e")
        }
    }
    val weatherIcon: MediatorLiveData<String> = MediatorLiveData<String>().apply {
        addSource(_weatherForecast) { weather ->
            weather.weatherStateAbbr?.let {
                postValue(
                    repository.getWeatherIconUrl(it)
                )
            }
        }
    }
}