package com.juanma.exercise.countries.presentation.screens.screenone.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.juanma.exercise.countries.presentation.ui.theme.Purple80

@Composable
fun SearchBar(
    modifier: Modifier,
    value: String,
    onValue: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = {
            onValue.invoke(it)
        },
        label = { Text(text = "Buscar pais") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .size(43.dp)
                    .padding(end = 6.dp),
                tint = Purple80
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(50.dp),
        modifier = modifier
    )
}