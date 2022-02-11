package com.lovely.weatherstation.datasource

import com.lovely.weatherstation.api.WeatherService

class Repository(override val weatherService: WeatherService) : HasWeatherApi