package com.lovely.weatherstation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CityWeatherItem(
    uiModel: CityWeatherItemUiModel
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = uiModel.cityName,
                style = typography.h6,
                color = Color.Black
            )
            Text(
                text = uiModel.weatherStateName.orEmpty(),
                style = typography.body2,
                color = Color.Gray
            )
            Text(
                text = uiModel.temperature.orEmpty(),
                style = typography.subtitle2,
                color = Color.Black
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = uiModel.weatherIconUrl,
                ),
                contentDescription = null,
                modifier = Modifier
                    .align(End)
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .size(36.dp)
            )
        }
    }
}