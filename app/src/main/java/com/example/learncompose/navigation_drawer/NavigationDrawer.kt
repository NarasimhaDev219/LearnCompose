package com.example.learncompose.navigation_drawer

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.ui.theme.GreenNR
import com.example.learncompose.ui.theme.LearnComposeTheme
import kotlinx.coroutines.launch

class NavigationDrawer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {

                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    LearnNavDrawer()
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationDrawerPreview() {
    LearnComposeTheme {
        LearnNavDrawer()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavDrawer() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            Column(
                modifier = Modifier
                    .width(250.dp) // Set your desired width here
                    .fillMaxHeight()
            ) {
                ModalDrawerSheet {
                    Box(
                        modifier = Modifier
                            .background(GreenNR)
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Text(text = "Add Something", color = Color.White)
                    }
                    HorizontalDivider()
                    //Navigation Drawer Item1
                    NavigationDrawerItem(label = { Text(text = "Home", color = GreenNR) },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home",
                                tint = GreenNR
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screens.Home.screen){
                                popUpTo(0)
                            }
                        })
                    //Navigation Drawer Item2
                    NavigationDrawerItem(label = { Text(text = "Profile", color = GreenNR) },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile",
                                tint = GreenNR
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screens.Profile.screen){
                                popUpTo(0)
                            }
                        })
                    //Navigation Drawer Item3
                    NavigationDrawerItem(label = { Text(text = "Settings", color = GreenNR) },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings",
                                tint = GreenNR
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navController.navigate(Screens.Settings.screen){
                                popUpTo(0)
                            }
                        })
                    //Navigation Drawer Item4
                    NavigationDrawerItem(label = { Text(text = "Logout", color = GreenNR) },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                contentDescription = "Logout",
                                tint = GreenNR
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            Toast.makeText(context,"Logout",Toast.LENGTH_SHORT).show()
                        })

                }
            }

        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "WhatsApp") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenNR,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                           coroutineScope.launch {
                               drawerState.open()
                           }
                        }) {
                            Icon(
                                Icons.Rounded.Menu,
                                contentDescription = "Menu Button "
                            )
                        }
                    },
                )
            }
        ) {
            NavHost(navController = navController,
                startDestination = Screens.Home.screen){
                composable(Screens.Home.screen) { Home() }
                composable(Screens.Profile.screen) { Profile() }
                composable(Screens.Settings.screen) { Settings() }
            }
        }
    }

}