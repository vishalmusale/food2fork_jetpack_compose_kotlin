package com.example.food2forkjetpackcomposekotlin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun RecipeListScreen(){
    Column(
        modifier = Modifier
            .border(border = BorderStroke(1.dp, Color.Black))
            .padding(16.dp)
    ) {

        Text("THIS IS A COMPOSABLE INSIDE THE FRAGMENT XML")
        Spacer(modifier = Modifier.padding(10.dp))
        CircularProgressIndicator()
        Spacer(modifier = Modifier.padding(10.dp))
        Text("NEAT")
        Spacer(modifier = Modifier.padding(10.dp))

        val context = LocalContext.current
        val customView = HorizontalDottedProgress(context)
        AndroidView(
            factory = { customView }
        )
    }
}