package com.lovely.weatherstation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lovely.weatherstation.datasource.Repository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val date: String,
    private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(
                forecastDate = date,
                repository = repository
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}