package com.lovely.weatherstation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lovely.weatherstation.datasource.Repository

class MainActivityViewModel(
    private val forecastDate: String,
    private val repository: Repository
) : ViewModel() {

    val cities = repository.getFavoriteCities()
    val forecasts = liveData {
        with(mutableListOf<CityWeatherItemModel>()) {
            cities.forEach { city ->

                val weather = repository.getWeatherForLocation(city.woeid)[1]

                add(
                    CityWeatherItemModel(
                        cityName = city.name,
                        weatherIconUrl = repository.getWeatherIconUrl(weather.weatherStateAbbr),
                        weatherStateName = weather.weatherStateName,
                        minTemperature = weather.minTemperature,
                        maxTemperature = weather.maxTemperature
                    )
                )
            }

            emit(this.toList())
        }
    }
}