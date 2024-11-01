package com.example.learncompose.navigation_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.R
import com.example.learncompose.login.HomeScreen
import com.example.learncompose.ui.theme.LearnComposeTheme

class NavigationComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    DisplayNavComponent()
                }
            }
        }
    }
}

@Composable
fun DisplayNavComponent(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.MainScreen.toString()) {
        composable(route = Destinations.MainScreen.toString()) {
            MainScreen(navController)
        }
        composable(route = Destinations.HomePage.toString()) {
            HomePage(navController)
        }
    }
}

@Composable
fun MainScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 100.dp),
            text = "Main Screen",
            fontSize = 30.sp,
            color = Color.Green
        )
        Button(
            modifier = Modifier
                .width(300.dp)
                .height(50.dp)
                .background(color = Color.Blue, shape = RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp),
            onClick = {
                navController.navigate(Destinations.HomePage.toString())
            }
        ) {
            Text("Go to HomePage")
        }
    }

}
/*
@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    LearnComposeTheme {
        MainScreen(navController = {})
    }
}*/



