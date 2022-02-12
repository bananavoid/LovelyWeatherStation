package com.lovely.weatherstation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.lovely.weatherstation.api.RetrofitBuilder
import com.lovely.weatherstation.datasource.Repository
import com.lovely.weatherstation.ui.theme.WeatherStationTheme
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                date = "",
                repository = Repository(
                    weatherService = RetrofitBuilder.weatherService,
                    dispatcher = Dispatchers.IO
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
    val isLoading by viewModel.isLoading.observeAsState(initial = true)
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
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .alpha(
                    if (isLoading) {
                        100f
                    } else {
                        0f
                    }
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherStationTheme {
    }
}