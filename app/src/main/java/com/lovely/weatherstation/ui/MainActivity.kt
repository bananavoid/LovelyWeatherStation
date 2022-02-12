package com.lovely.weatherstation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.lovely.weatherstation.api.RetrofitBuilder
import com.lovely.weatherstation.datasource.Repository
import com.lovely.weatherstation.ui.theme.WeatherStationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                date = "",
                repository = Repository(
                    RetrofitBuilder.weatherService
                )
            )
        ).get(MainActivityViewModel::class.java)

        setContent {
            WeatherStationTheme {
                WeatherStationApp(viewModel)
            }
        }
    }
}

@Composable
fun WeatherStationApp(
    viewModel: MainActivityViewModel
) {
    Scaffold(
        content = {
            CitiesWeatherContent(viewModel)
        }
    )
}

@Composable
fun CitiesWeatherContent(
    viewModel: MainActivityViewModel
) {
    val forecasts by viewModel.forecasts.observeAsState(initial = emptyList())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(
            items = forecasts,
            itemContent = {
                CityWeatherItem(
                    uiModel = it
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherStationTheme {
    }
}