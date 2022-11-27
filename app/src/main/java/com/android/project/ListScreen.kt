package com.android.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.android.project.model.News
import com.android.project.ui.theme.ProjectTheme

@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()//Inyectar viewModel
){
    val newsList by viewModel.getNews().observeAsState(initial = emptyList())//obtener datos
    ListScreen(navController, newsList)

}

@Composable
fun ListScreen(
    navController: NavController,
    news: List<News>
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top news")}
            )
        }
    ) {
        LazyColumn{
            items(news) { new ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { //TODO
                             },
                ) {
                    Column {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f),
                            painter = rememberImagePainter(
                                data = new.urlToImage,
                                builder = {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth
                        )//Image
                        Column(Modifier.padding(8.dp)) {
                            androidx.compose.material.Text(
                                new.title,
                                fontSize = 18.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                            androidx.compose.material.Text(new.content ?: "", maxLines = 3)

                        }//Column
                    }//Main Column
                }//Card
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun ListPreview() {
    ProjectTheme {
        ListScreen(
            navController = rememberNavController(),
            news = arrayListOf(
                News(
                    "Title", "Content", "author", "url", "url"
                ),
                News(
                    "Title 2", "Content 2", "author", "url", "url"
                ),
            )
            )
    }
}
