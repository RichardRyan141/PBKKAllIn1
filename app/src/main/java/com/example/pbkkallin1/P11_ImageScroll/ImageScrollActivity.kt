package com.example.pbkkallin1.P11_ImageScroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pbkkallin1.ui.theme.DefaultTheme
import com.example.pbkkallin1.R

class ImageScrollActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()
        }
    }
}

data class ImageItem(val imageResId: Int, val description: String)

val sampleImages = listOf(
    ImageItem(R.drawable.image_scroll_1, "Pantai saat senja"),
    ImageItem(R.drawable.image_scroll_2, "Orang mendayung perahu di laut"),
    ImageItem(R.drawable.image_scroll_3, "Golden Gate"),
    ImageItem(R.drawable.image_scroll_4, "Gunung di tepi pantai"),
    ImageItem(R.drawable.image_scroll_5, "Danau")
)

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(sampleImages) { item ->
            ImageCard(imageItem = item)
        }
    }
}

@Composable
fun ImageCard(imageItem: ImageItem) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(id = imageItem.imageResId),
                contentDescription = imageItem.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = imageItem.description,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DefaultTheme {
        HomeScreen()
    }
}