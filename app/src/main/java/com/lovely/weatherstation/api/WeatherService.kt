package com.lovely.weatherstation.api

import com.lovely.weatherstation.datasource.model.ConsolidatedWeather
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("location/{woeid}/")
    suspend fun getWeatherForLocation(@Path("woeid") woeid: Long): ConsolidatedWeather
}