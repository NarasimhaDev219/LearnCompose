package com.example.learncompose.navigation_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learncompose.ui.theme.GreenNR
import com.example.learncompose.ui.theme.LearnComposeTheme

@Composable
fun HomePage(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Home Page",
                fontSize = 30.sp,
                color = GreenNR,
                modifier = Modifier.padding(bottom = 100.dp)
            )
            Button(
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
                    .background(color = Color.Blue, shape = RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(20.dp),
                onClick = {
                    navController.popBackStack(Destinations.MainScreen.toString(), inclusive = false)
                }
            ) {
                Text("Go to MainScreen")
            }

        }
    }
}