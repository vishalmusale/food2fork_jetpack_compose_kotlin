package com.example.food2forkjetpackcomposekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyScrollableLayout()
        }
    }

    @Composable
    fun DisplayImage() {

    }

    @Composable
    fun MyScrollableLayout() {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF2F2F2))
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = R.drawable.happy_meal_small),
                contentDescription = "A delicious happy meal",
                modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Happy Meal",
                style = TextStyle(
                    fontSize = 26.sp
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "800 calories",
                style = TextStyle(
                    fontSize = 17.sp
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "$5.99",
                style = TextStyle(
                    fontSize = 17.sp,
                    color = Color(0xFF85bb65)
                )
            )
        }
    }
}