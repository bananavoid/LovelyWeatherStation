package com.lovely.weatherstation.datasource.model

import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(
    @SerializedName("consolidated_weather")
    val forecasts: List<Weather>
)