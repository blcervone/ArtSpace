package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenLayout()
                }
            }
        }
    }
}



@Composable
fun ImageCard(
    @DrawableRes image: Int,
    @StringRes contentDesc: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 12.dp,
        modifier = Modifier
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(contentDesc),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun InfoCard(
    @StringRes title: Int,
    @StringRes artist: Int,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(title), fontWeight = FontWeight.Bold ,modifier = Modifier.padding(start = 12.dp, top = 12.dp))
        Text(text = stringResource(artist), fontStyle = FontStyle.Italic, modifier = Modifier.padding(start = 12.dp, bottom = 12.dp))
    }
}

@Composable
fun ButtonRow(imageCounter: Int, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = {
                    if (imageCounter == 1) {

                    } else {

                    }
                         },
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(text = "Prev", modifier = Modifier.padding(start = 24.dp, end = 24.dp))
        }
        Button(
            onClick = {

                         },
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(text = "Next",  modifier = Modifier.padding(start = 24.dp, end = 24.dp))
        }
    }
}

@Composable
fun ScreenLayout(modifier: Modifier = Modifier) {
    var imageCounter by remember { mutableStateOf(1) }

    val image = when (imageCounter) {
        1 -> R.drawable.mona_lisa
        else -> R.drawable.bethsheba_in_the_bath
    }
    val artist = when (imageCounter) {
        1 -> R.string.leo_davinci
        else -> R.string.rembrandt
    }
    val title = when (imageCounter) {
        1 -> R.string.mona_lisa
        else -> R.string.bethsheba
    }
    val contentDesc = when (imageCounter) {
        1 -> R.string.mona_lisa_content_desc
        else -> R.string.bb_content_desc
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageCard(image, contentDesc)
        Spacer(modifier = Modifier.size(8.dp))
        InfoCard(title, artist)
        Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (imageCounter == 2) {
                    imageCounter--
                }
            },
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(text = "Prev", modifier = Modifier.padding(start = 24.dp, end = 24.dp))
            }
            Button(
                onClick = {
                    if (imageCounter == 1) {
                        imageCounter++
                    }
                },
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(text = "Next",  modifier = Modifier.padding(start = 24.dp, end = 24.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ScreenLayout()
    }
}