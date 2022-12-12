package com.johnyalam.copmoserandroid.presentation


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.johnyalam.copmoserandroid.R
import com.johnyalam.copmoserandroid.presentation.ui.theme.CopmoserAndroidTheme

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
    rememberCoroutineScope()
    val scrollState = rememberScrollState()

    val imageUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png"
    val title = "Argentina: Messi’s last dance reaches the semis"
    val description =
        "The Qatar World Cup has entered its final stretch as only four out of the 32 teams remain in the hunt to win the biggest prize in international football. Two out of the four names – Argentina and France"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {

        GreetingOne(name = name)
        GreetingTwo(name = name)
        MultipleStylesInText()
        OverflowedText()
        BrushTextStyle(name)
        TextInputField()
        ArtistCard()
        ButtonView()
        ImageFromURL()
        CardView(imageUrl, title, description)
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
fun GreetingOne(name: String) {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello $name!",
        style = TextStyle(
            color = Color.Green,
            fontStyle = FontStyle.Italic,
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
fun GreetingTwo(name: String) {
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
    Text(
        "Hello Compose ".repeat(50),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(top = 10.dp)
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun BrushTextStyle(name: String) {
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
private fun TextInputField() {
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(Color.Green, Color.Red, Color.Yellow, Black)
        )
    }

    TextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(brush = brush),
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ArtistCard() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 20.dp)
            .background(Color.White)
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_person_24),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(5.dp)
        )
        Column {
            Text("Title")
            Text("Image detials ")
        }
    }
}

@Composable
fun ButtonView() {
    Button(
        onClick = {
            Log.d("MainAc", "Clicked...")
        },
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        ),

        ) {
        // Inner content including an icon and a text label
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}

// on below line we are creating an
// image url function for our image view.
@Composable
fun ImageFromURL() {

    // on below line we are creating a column,Œ
    Column(
        // in this column we are adding modifier
        // to fill max size, mz height and max width
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            // on below line we are adding
            // padding from all sides.
            .padding(10.dp),
        // on below line we are adding vertical
        // and horizontal arrangement.
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png",
            contentDescription = "Translated description of what the image contains"
        )

        AsyncImage(
            model = "https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png",
            contentDescription = "Translated description of what the image contains",
            modifier = Modifier
                .wrapContentSize()
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(10.dp)
        )
    }
}

@Composable
fun CardView(
    imageUrl: String,
    title: String,
    description: String
) {

    BoxWithConstraints {
        if (maxWidth > 400.dp) {
            Column {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Translated description of what the image contains"
                )
                Text(title)
            }
        } else {
            Row {
                Column {
                    Text(title)
                    Text(description)
                }
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Translated description of what the image contains"
                )
            }
        }
    }
}



