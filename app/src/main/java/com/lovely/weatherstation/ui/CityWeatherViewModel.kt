package com.lovely.weatherstation.ui

import androidx.lifecycle.ViewModel
import com.lovely.weatherstation.datasource.Repository

class CityWeatherViewModel(
    private val repository: Repository
) : ViewModel()