package com.lovely.weatherstation.ui

data class CityWeatherItemUiModel(
    val cityName: String,
    val weatherIconUrl: String,
    val weatherStateName: String?,
    val temperature: String?
)