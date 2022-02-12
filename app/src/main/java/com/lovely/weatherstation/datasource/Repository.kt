package com.lovely.weatherstation.datasource

import com.lovely.weatherstation.api.WeatherService
import kotlinx.coroutines.CoroutineDispatcher

class Repository(
    override val weatherService: WeatherService, override val dispatcher: CoroutineDispatcher
) : HasWeatherApi, HasCityApi