package com.example.chapter_8_allminitask.philippcourse

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class Eps9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenbox")
                val redBox = createRefFor("redbox")
                val guideline =
                    createGuidelineFromTop(0.5f) // Ini kek jarak nya, ditentuin make 0.5f(50%)

                constrain(greenBox) {
                    top.linkTo(guideline)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                constrain(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end) // ini jadi di tengah", c, ketarik, yg kanan dipaksa end, yg kiri disangkutin ke end-greenboxnya
                    width = Dimension.value(100.dp)
//                    width = Dimension.fillToConstraints // ini tempelin ke batas ujung width
                    height = Dimension.value(100.dp)
                }
                // Chain ini buat nge rantai sesama constrain dgn jarak yg sama
                // meskipun si redbox nya dia make parent end, si green nya ikutan, jadi kayak saling
                // nyangkut, ngasih jarak kesamping sama besar, test aja dewek!!
                createHorizontalChain(greenBox, redBox,
                    chainStyle = ChainStyle.Packed // ini buat si constrain itu jadi ngedekt
                )
            }
            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenbox")
                )
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redbox")
                )

            }
        }
    }
}