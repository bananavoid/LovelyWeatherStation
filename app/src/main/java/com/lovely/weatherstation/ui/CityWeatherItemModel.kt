package com.lovely.weatherstation.ui

class CityWeatherItemModel(
    val cityName: String,
    val weatherIconUrl: String,
    val weatherStateName: String?,
    val minTemperature: Float?,
    val maxTemperature: Float?
)