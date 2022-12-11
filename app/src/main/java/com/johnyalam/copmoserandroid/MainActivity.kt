package com.johnyalam.copmoserandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnyalam.copmoserandroid.ui.theme.CopmoserAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CopmoserAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(10.dp) ) {

        GreetingOne(name = name)
        GreetingTwo(name = name)
        MultipleStylesInText()
        OverflowedText()
        BrushTextStyle(name)
        TextInputField()
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CopmoserAndroidTheme {
        Greeting("Android")
    }
}

@Composable
fun GreetingOne(name: String){
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello $name!" ,
        style = TextStyle(
            color = Color.Green,
            fontStyle = FontStyle.Italic ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            shadow = Shadow(
                color = Color.LightGray,
                offset = offset,
                blurRadius = 3f
            )
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun GreetingTwo(name: String){
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello world $name!",
        style = TextStyle(
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset,
                blurRadius = 3f
            )
        ),
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        },
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Composable
fun OverflowedText() {
    Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(top = 10.dp))
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun BrushTextStyle(name: String){
     val GradientColors = listOf(Cyan, Black)

    Text(
        text = name,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = GradientColors
            )
        ),
        modifier = Modifier.padding(top = 10.dp)
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalTextApi::class)
@Composable
fun TextInputField(){
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(Color.Green, Color.Red, Color.Yellow, Color.Black)
        )
    }

    TextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(brush = brush),
        modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
    )
}
