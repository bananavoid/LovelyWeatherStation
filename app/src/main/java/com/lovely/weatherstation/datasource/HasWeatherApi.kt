package com.lovely.weatherstation.datasource

import com.lovely.weatherstation.api.WeatherService
import com.lovely.weatherstation.datasource.model.Weather
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface HasWeatherApi {

    val weatherService: WeatherService
    val dispatcher: CoroutineDispatcher

    suspend fun getWeatherForLocation(woeid: Long): List<Weather> {
        return withContext(dispatcher) {
            weatherService.getWeatherForLocation(woeid = woeid).forecasts
        }
    }

    fun getWeatherIconUrl(abbreviation: String?): String {
        return "https://www.metaweather.com/api/static/img/weather/$abbreviation.svg"
    }
}