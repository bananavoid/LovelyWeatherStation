package com.lovely.weatherstation.datasource

import com.lovely.weatherstation.datasource.model.City

interface HasCityApi {

    fun getFavoriteCities(): List<City> {
        return listOf(
            City(
                woeid = 890869,
                name = "Gothenburg"
            ),
            City(
                woeid = 906057,
                name = "Stockholm"
            ),
            City(
                woeid = 2455882,
                name = "MountainView"
            ),
            City(
                woeid = 44418,
                name = "London"
            ),
            City(
                woeid = 2459115,
                name = "New York"
            ),
            City(
                woeid = 638242,
                name = "Berlin"
            )
        )
    }
}