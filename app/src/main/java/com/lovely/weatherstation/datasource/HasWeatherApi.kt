package com.lovely.weatherstation.datasource

import com.lovely.weatherstation.api.WeatherService
import com.lovely.weatherstation.datasource.model.Weather

interface HasWeatherApi {

    val weatherService: WeatherService

    suspend fun getWeatherForLocation(woeid: Long): List<Weather> {
        return weatherService.getWeatherForLocation(woeid = woeid)
    }
}