package com.example.chapter_8_allminitask.philippcourse

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainPhilippCourse : AppCompatActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MainContent()
//        ToastDemo()
            ManggilButton()
        }
    }
}

@Composable
fun ToastDemo() {
    val context = LocalContext.current
    Column(
        content = {
            Button(onClick = {
                Toast.makeText(
                    context,
                    "Showing toast....",
                    Toast.LENGTH_SHORT
                ).show()
            }, content = {
                Text(text = "Show Toast")
            })
        }, modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
}

// Function to generate a Toast
//private fun mToast(context: Context) {
//    Toast.makeText(context, "This is a Sample Toast", Toast.LENGTH_LONG).show()
//}

@ExperimentalFoundationApi
@Composable
fun MainContent() {

    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Column(

        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxSize()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                context.startActivity(Intent(context, Eps1::class.java))
            },

            shape = RoundedCornerShape(12.dp),
            modifier = Modifier,
//                .clickable(
//                    onClick = {
//                        println("Single Click")
//                    }
//                    onLongClick = {
//                        println("Long Click")
//                    },
//                    onDoubleClick = {
//                        println("Double Tap")
//                    },
//                )
//                .combinedClickable(
//                    onClick = {
//                        context.startActivity(Intent(context, Eps1::class.java))
//                    },
//                    onLongClick = {
//                        Toast.makeText(context, "Toast ini bang", Toast.LENGTH_SHORT).show()
//                    })
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
        ) {
            Text("Episode pertama", color = Color.White)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PrevManggilBUtton() {
    ManggilButton()
}

@Composable
fun ManggilButton(context: Context = LocalContext.current) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background) //ini make bg lightwhite
            .fillMaxSize()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Button Eps 1
        ButtonComponent(
            context = context,
            intent = Intent(context, Eps1::class.java),
            buttonText = "Episode pertama!"
        )
        // Button Eps 3
        ButtonComponent(
            context = context,
            intent = Intent(context, Eps3::class.java),
            buttonText = "Episode Ketiga!"
        )

        // Button Eps 9
        ButtonComponent(
            context = context,
            intent = Intent(context, Eps9::class.java),
            buttonText = "Episode Sembilan!"
        )

        // SplashScreen
        ButtonComponent(
            context = context,
            intent = Intent(context, SplashScreen::class.java),
            buttonText = "SplashScreen"
        )


    }

}

@Composable
fun ButtonComponent(context: Context, intent: Intent, buttonText: String) {
    Button(
        onClick = {
            context.startActivity(intent)
        },
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            text = buttonText,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}


