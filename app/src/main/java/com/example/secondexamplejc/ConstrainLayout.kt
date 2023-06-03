package com.example.secondexamplejc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample01(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxBlue, boxYellow, boxRed, boxGreen, boxCyan) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxBlue.bottom)
                start.linkTo(boxBlue.end)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                top.linkTo(boxBlue.bottom)
                end.linkTo(boxBlue.start)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                bottom.linkTo(boxBlue.top)
                end.linkTo(boxBlue.start)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                bottom.linkTo(boxBlue.top)
                start.linkTo(boxBlue.end)
            })
    }
}

@Composable
fun ConstraintExampleGuide(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val boxBlue = createRef()

        //val startGuide = createGuidelineFromTop(16.dp)
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })

    }
}

@Composable
fun ConstraintBarrier(){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxBlue, boxYellow, boxRed) = createRefs()
        val barrier = createEndBarrier(boxBlue, boxYellow)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(parent.start, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(225.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxBlue.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(barrier)
            })
    }

}

@Preview
@Composable
fun ConstraintChainExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxBlue, boxYellow, boxRed) = createRefs()

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(parent.start)
                end.linkTo(boxYellow.start)
            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxBlue.end)
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(boxYellow.end)
                end.linkTo(parent.end)
            })

        createHorizontalChain(boxBlue, boxYellow, boxRed, chainStyle = ChainStyle.SpreadInside)

    }
}