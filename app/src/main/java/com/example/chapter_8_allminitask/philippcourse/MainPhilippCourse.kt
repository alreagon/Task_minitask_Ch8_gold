package com.example.chapter_8_allminitask.philippcourse

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

class MainPhilippCourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MainContent()
        ToastDemo()
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent() {

    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                context.startActivity(Intent(context, Eps1::class.java))
            },
            modifier = Modifier
//                .pointerInput(Unit) {
//                    detectTapGestures(
//                        onLongPress = {},
//                    )
//                }
                .combinedClickable(
                    onClick = {
                        context.startActivity(Intent(context, Eps1::class.java))
                    },
                    onLongClick = {
                        Toast.makeText(context, "Toast ini bang", Toast.LENGTH_SHORT).show()
                    }),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
        ) {
            Text("Episode pertama", color = Color.White)
        }
    }
}


