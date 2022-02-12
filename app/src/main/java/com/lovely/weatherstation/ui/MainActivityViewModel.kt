package com.lovely.weatherstation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lovely.weatherstation.datasource.Repository
import com.lovely.weatherstation.datasource.model.Weather
import kotlin.math.roundToInt

// TODO fix request to use forecastDate instead of rely on index
private const val TOMORROW_DAY_INDEX = 1

class MainActivityViewModel(
    private val forecastDate: String,
    private val repository: Repository
) : ViewModel() {

    val isLoading = MutableLiveData(true)
    private val cities = repository.getFavoriteCities()
    private val _forecasts = liveData {
        with(mutableListOf<CityWeatherItemUiModel>()) {
            cities.forEach { city ->
                var weather: Weather? = null
                try {
                    weather = repository.getWeatherForLocation(city.woeid)[TOMORROW_DAY_INDEX]
                } catch (e: Exception) {
                    Log.e("MainActivityViewModel", "Error while fetching weather for ${city.name}")
                }

                add(
                    CityWeatherItemUiModel(
                        cityName = city.name,
                        weatherIconUrl = repository.getWeatherIconUrl(weather?.weatherStateAbbr),
                        weatherStateName = weather?.weatherStateName,
                        temperature = weather?.temperature?.let { "${it.roundToInt()}°" } // TODO use proper string resource
                    )
                )
            }

            emit(this.toList())
            isLoading.postValue(false)
        }
    }
    val forecasts: LiveData<List<CityWeatherItemUiModel>> = _forecasts
}