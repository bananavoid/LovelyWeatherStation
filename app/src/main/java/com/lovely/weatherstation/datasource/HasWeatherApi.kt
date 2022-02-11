package com.lovely.weatherstation.datasource

import com.lovely.weatherstation.api.WeatherService

interface HasWeatherApi {

    val weatherService: WeatherService

    suspend fun getWeatherForLocation(woeid: Long): List<Weather> {
        return weatherService.getWeatherForLocation(woeid = woeid)
    }
}