package com.example.learncompose.bottom_navigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.navigation_drawer.Home
import com.example.learncompose.navigation_drawer.Profile
import com.example.learncompose.ui.theme.GreenNR
import com.example.learncompose.ui.theme.LearnComposeTheme

class BottomNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                BottomNav()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    LearnComposeTheme {
        BottomNav()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {

    val navController = rememberNavController()
    val context = LocalContext.current
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    Scaffold(
        bottomBar = {
        BottomAppBar(
            containerColor = GreenNR,
        ) {
            //Icon1
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Home
                    navController.navigate(BottomScreens.Home.screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)
            ) {

                Icon(
                    Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                )
            }

            //Icon2
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Search
                    navController.navigate(BottomScreens.Search.screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)
            ) {

                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                )
            }
            //Icon3
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(onClick = { showBottomSheet = true }) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = GreenNR)
                }
            }
            //Icon4
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Notifications
                    navController.navigate(BottomScreens.Notification.screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)
            ) {

                Icon(
                    Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
                )
            }
            //Icon5
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Person
                    navController.navigate(BottomScreens.Profile.screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)
            ) {

                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                )
            }

        }
    }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomScreens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(BottomScreens.Home.screen) { Home() }
            composable(BottomScreens.Search.screen) { Search() }
            composable(BottomScreens.Notification.screen) { Notification() }
            composable(BottomScreens.Profile.screen) { Profile() }
            composable(BottomScreens.Post.screen) { Post() }
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false }, sheetState = sheetState
            ) {

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    //item1
                    BottomSheetItem(icon = Icons.Default.ThumbUp,"Create Post"){
                        showBottomSheet = false
                        navController.navigate(BottomScreens.Post.screen){
                            popUpTo(0)
                        }

                    }
                    //item2
                    BottomSheetItem(icon = Icons.Default.Star,"Add a Story"){
                        Toast.makeText(context,"Story",Toast.LENGTH_SHORT).show()
                    }
                    //item3
                    BottomSheetItem(icon = Icons.Default.PlayArrow,"Create a Reel"){
                        Toast.makeText(context,"Reel",Toast.LENGTH_SHORT).show()
                    }
                    //item4
                    BottomSheetItem(icon = Icons.Default.Favorite,"Go Live"){
                        Toast.makeText(context,"Live",Toast.LENGTH_SHORT).show()
                    }

                }

            }
        }
    }
}
@Composable
fun BottomSheetItem(icon: ImageVector, title: String, onClick: () -> Unit) {

    Row(
        modifier = Modifier.clickable {
            onClick()
        },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = GreenNR)
        Text(text = title, color = GreenNR, fontSize = 22.sp)
    }

}