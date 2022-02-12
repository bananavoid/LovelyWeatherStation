package com.lovely.weatherstation.datasource

import com.lovely.weatherstation.api.WeatherService
import com.lovely.weatherstation.datasource.model.Weather

interface HasWeatherApi {

    val weatherService: WeatherService

    suspend fun getWeatherForLocation(woeid: Long): List<Weather> {
        return weatherService.getWeatherForLocation(woeid = woeid)
    }

    fun getWeatherIconUrl(abbreviation: String?): String {
        return "https://www.metaweather.com/api/static/img/weather/$abbreviation.svg"
    }
}