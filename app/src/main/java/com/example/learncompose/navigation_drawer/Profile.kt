package com.example.learncompose.navigation_drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.learncompose.ui.theme.GreenNR
import com.example.learncompose.ui.theme.LearnComposeTheme


@Composable
fun Profile() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Profile", fontSize = 30.sp, color = GreenNR)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview(){
    LearnComposeTheme {
        Profile()
    }
}