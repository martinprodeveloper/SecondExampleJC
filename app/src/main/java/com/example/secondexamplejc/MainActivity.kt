package com.example.secondexamplejc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.secondexamplejc.ui.theme.SecondExampleJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondExampleJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyStateExample()
                }
            }
        }
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(Color.Gray)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.TopCenter
        ) {
            Text(text = "SECOND EXAMPLE JC", color = Color.White)
        }
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Example 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 2", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 3", modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 4", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 5", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 6", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 7", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 8", modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 9", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Example 10", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyRow() {
    /*Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Example 1")
        Text(text = "Example 2")
        Text(text = "Example 3")
        Text(text = "Example 4")
        Text(text = "Example 5")
    }*/
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "Example 1", modifier = Modifier.width(100.dp))
        Text(text = "Example 2", modifier = Modifier.width(100.dp))
        Text(text = "Example 3", modifier = Modifier.width(100.dp))
        Text(text = "Example 4", modifier = Modifier.width(100.dp))
        Text(text = "Example 5", modifier = Modifier.width(100.dp))
        Text(text = "Example 6", modifier = Modifier.width(100.dp))
        Text(text = "Example 7", modifier = Modifier.width(100.dp))
        Text(text = "Example 8", modifier = Modifier.width(100.dp))
        Text(text = "Example 9", modifier = Modifier.width(100.dp))
        Text(text = "Example 10", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        MySpacer(size = 30)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.LightGray), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Gray), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3", color = Color.White)
            }
        }
        MySpacer(size = 50)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }

        Text(text = "Se ha pulsado ${counter} veces")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SecondExampleJCTheme {
        MyStateExample()
    }
}