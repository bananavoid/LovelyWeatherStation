package com.lovely.weatherstation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.lovely.weatherstation.datasource.Repository
import kotlinx.coroutines.Dispatchers

class CityWeatherItemModel(
    val cityName: String,
    val weatherIconUrl: String,
    val weatherStateName: String?,
    val minTemperature: Float?,
    val maxTemperature: Float?
)