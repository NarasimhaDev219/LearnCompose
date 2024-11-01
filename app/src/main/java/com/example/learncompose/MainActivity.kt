package com.example.learncompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.learncompose.ui.theme.GreenNR
import com.example.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            LearnComposeTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // RowAndColumnBox()
                    //LearnButton()
                    //LearnState()
                    //LearnAppBar()
                    //ListLazyColumnAndRow()
                    ConstraintLayoutExample()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyNamePreview() {
    LearnComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // RowAndColumnBox()
            //LearnButton()
            //LearnState()
            LearnAppBar()
            //ListLazyColumnAndRow()
            //ConstraintLayoutExample()
        }
    }

}

@Composable
fun ConstraintLayoutExample() {

    ConstraintLayout(modifier = Modifier.padding(80.dp).fillMaxSize()) {
        val (redButton, greenButton, blueButton, blackButton) = createRefs()

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier.constrainAs(redButton) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.wrapContent
            }) {
            Text(text = "Red")
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.constrainAs(greenButton) {
                top.linkTo(redButton.bottom)
            }) {
            Text(text = "Green")
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.constrainAs(blueButton) {
                top.linkTo(redButton.bottom)
            }) {
            Text(text = "Blue")
        }

        createHorizontalChain(greenButton,blueButton, chainStyle = ChainStyle.Spread)
        val guidLine = createGuidelineFromBottom(0.01f)
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.constrainAs(blackButton) {
                //top.linkTo(blueButton.bottom)
                bottom.linkTo(guidLine)
            }) {
            Text(text = "Black")
        }
    }

}

@Composable
fun ListLazyColumnAndRow() {
    val fruitsList = listOf(
        "Banana",
        "Apple",
        "Papaya",
        "Grapes",
        "Watermelon",
        "Banana",
        "Apple",
        "Papaya",
        "Grapes",
        "Watermelon",
        "Banana",
        "Apple",
        "Papaya",
    )
    /*
        Column {
            //Example for list
            fruitsList.forEach {
                Text(text = it, fontSize = 30.sp, color = Color.Green)
            }
        }*/

    //Example for LazyColumn
    /* LazyColumn {
         items(fruitsList){
             Text(text = it, fontSize = 50.sp, color = Color.Green, modifier = Modifier.padding(vertical = 10.dp))
         }
     }*/
    //Example for LazyRow
    LazyRow {
        items(fruitsList) {
            Text(
                text = it,
                fontSize = 30.sp,
                color = Color.Green,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 100.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnAppBar() {

    val context = LocalContext.current

    TopAppBar(title = { Text(text = "WhatsApp") },
        navigationIcon = {
            IconButton(onClick = {
                Toast
                    .makeText(context, "Whats App Icon Clicked", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    painter = painterResource(
                        R.drawable.whatsapp_icon
                    ),
                    contentDescription = null, modifier = Modifier.padding(5.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenNR,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast
                    .makeText(context, "Profile", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Person",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                Toast
                    .makeText(context, "Search", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                Toast
                    .makeText(context, "Menu", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun LearnState() {

    var age by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { age++ }) {
            Text(text = "I am $age years old")
        }

    }
}

@Composable
fun RowAndColumnBox() {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .border(5.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
                .background(color = Color.Blue, shape = RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Hello Android",
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable {
                        Toast
                            .makeText(context, "I am Clicked", Toast.LENGTH_LONG)
                            .show()
                    },
                color = Color.White,
                fontSize = 20.sp,
            )
        }

    }
}

@Composable
fun LearnButton() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            colors = ButtonColors(
                Color.Magenta,
                contentColor = Color.Yellow,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.Gray
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
            }) {
            Text(text = "Login", color = Color.White, fontSize = 20.sp)
        }
    }
}

