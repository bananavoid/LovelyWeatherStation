package com.lovely.weatherstation.datasource.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("weather_state_name")
    val weatherStateName: String?,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String?,
    @SerializedName("wind_direction_compass")
    val windDirectionCompass: String?,
    @SerializedName("created")
    val createdAt: String?,
    @SerializedName("applicable_date")
    val applicableDate: String?,
    @SerializedName("min_temp")
    val minTemperature: Float?,
    @SerializedName("max_temp")
    val maxTemperature: Float?,
    @SerializedName("the_temp")
    val temperature: Float?,
    @SerializedName("wind_speed")
    val windSpeed: Float?,
    @SerializedName("wind_direction")
    val windDirection: Float?,
    @SerializedName("air_pressure")
    val airPressure: Float?,
    @SerializedName("humidity")
    val humidity: Float?,
    @SerializedName("visibility")
    val visibility: Float?,
    @SerializedName("predictability")
    val predictability: Float?
)