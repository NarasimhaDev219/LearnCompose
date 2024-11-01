package com.example.learncompose.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.R
import com.example.learncompose.navigation_drawer.Home
import com.example.learncompose.ui.theme.GreenNR
import com.example.learncompose.ui.theme.LearnComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painterResource(R.drawable.loginbg),
                            contentScale = ContentScale.FillBounds
                        )
                ) {
                    val navController = rememberNavController()

                    NavGraph(navController)

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {

}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 26.dp, vertical = 200.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "UserName") },
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = GreenNR,
                unfocusedLeadingIconColor = GreenNR,
                focusedLabelColor = GreenNR,
                unfocusedLabelColor = GreenNR,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = GreenNR,
                unfocusedIndicatorColor = GreenNR,
                unfocusedPlaceholderColor = GreenNR
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "UserName"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = GreenNR,
                unfocusedLeadingIconColor = GreenNR,
                focusedLabelColor = GreenNR,
                unfocusedLabelColor = GreenNR,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = GreenNR,
                unfocusedIndicatorColor = GreenNR,
                unfocusedPlaceholderColor = GreenNR
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                if (authenticate(userName, password)) {
                    onLoginSuccess()
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(GreenNR),
            contentPadding = PaddingValues(horizontal = 60.dp, vertical = 8.dp),
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Text(text = "Login", fontSize = 22.sp)

        }

    }

}

private fun authenticate(username: String, password: String): Boolean {

    val validUserName = "Narasimha"
    val validPassword = "qwertyu"
    return username == validUserName && password == validPassword
}


@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                navHostController.navigate("home") {
                    popUpTo(0)
                }
            })
        }
        composable("home") {
            HomeScreen()
        }

    }

}