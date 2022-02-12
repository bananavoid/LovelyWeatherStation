package com.lovely.weatherstation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lovely.weatherstation.datasource.Repository
import com.lovely.weatherstation.datasource.model.Weather

// TODO fix request to use forecastDate instead of rely on index
private const val TOMORROW_DAY_INDEX = 1

class MainActivityViewModel(
    private val forecastDate: String,
    private val repository: Repository
) : ViewModel() {

    private val cities = repository.getFavoriteCities()
    private val _forecasts = liveData {
        with(mutableListOf<CityWeatherItemModel>()) {
            cities.forEach { city ->
                var weather: Weather? = null
                try {
                    weather = repository.getWeatherForLocation(city.woeid)[TOMORROW_DAY_INDEX]
                } catch (e: Exception) {
                    Log.e("MainActivityViewModel", "Error while fetching weather for ${city.name}")
                }

                add(
                    CityWeatherItemModel(
                        cityName = city.name,
                        weatherIconUrl = repository.getWeatherIconUrl(weather?.weatherStateAbbr),
                        weatherStateName = weather?.weatherStateName,
                        minTemperature = weather?.minTemperature,
                        maxTemperature = weather?.maxTemperature
                    )
                )
            }

            emit(this.toList())
        }
    }
    val forecasts: LiveData<List<CityWeatherItemModel>> = _forecasts
}