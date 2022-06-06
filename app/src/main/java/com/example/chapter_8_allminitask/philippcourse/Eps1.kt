package com.example.chapter_8_allminitask.philippcourse

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Eps1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            eps1()
        }

    }
}


@Composable
fun eps1() {

    Surface(color = MaterialTheme.colors.primary) {

        Column(
            modifier = Modifier
                .fillMaxHeight(0.7f) // 0.7f ini artinya 70% dari screen, napa dari screen? karena make fillMaxHeight
                .width(300.dp)
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly // Ini ngebuat tiap space di text itu sama rata
//        verticalArrangement = Arrangement.SpaceBetween // Ini ngebuat space antara text sampe mentok column nya, jadi tdk ada ruang untuk selain yang diantara text
            verticalArrangement = Arrangement.SpaceAround // Ini membuat tiap space di antara text itu sama, tapi di luar tiap space itu setengahnya dari space yg di antara text
        ) {
            Text(text = "Ini atas")
            Text(text = "Ini tengah")
            Text(text = "Ini bawah")
        }


    }
}

@Composable
fun eps1_2() {
    Row(
        modifier = Modifier
//            .fillMaxSize() // ini bisa dipake kalo mau custom size layout, tapi make 1f / 0.5f , gitu" dah, ribet, no rekomended
            .height(300.dp) // mending make ini kalo pengen custom size layout nya
            .width(300.dp)
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceAround, // ini kebalik sama yg column, perhatiin coba
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Ini atas")
        Text(text = "Ini tengah")
        Text(text = "Ini bawah")
    }
}

@Preview(showBackground = true)
@Composable
fun prev() {
    eps1()
//    eps1_2()
}