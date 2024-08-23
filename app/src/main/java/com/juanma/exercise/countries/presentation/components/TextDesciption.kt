package com.juanma.exercise.countries.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.juanma.exercise.countries.presentation.ui.theme.Black

@Composable
fun TextDescription(text: String) {
    Text(
        text = text,
        color = Black,
        fontSize = 17.sp
    )
}