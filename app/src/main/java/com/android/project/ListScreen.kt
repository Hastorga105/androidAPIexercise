package com.android.project

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
fun ListScreen(viewModel: ListScreenViewModel = hiltViewModel()/*Inyectar viewModel*/) {
    val newsList by viewModel.getNews().observeAsState(initial = emptyList())//obtener datos
    ListScreen(newsList)
}

val font = FontFamily(
    Font(R.font.rajdhaniregular),
    Font(R.font.rajdhanibold, weight = FontWeight.Bold)
)


@Composable
fun ListScreen(news: List<News>) {
    Scaffold(
        topBar = {
            Card(
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color(0xFFF34151D)
            ) {
                Column {
                    Row(
                        Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 16.dp)
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black)
                                .size(50.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.icon1),
                                contentDescription = null
                            )
                        }
                        Card(
                            shape = RoundedCornerShape(0.dp),
                            elevation = 0.dp,
                            border = BorderStroke(3.dp, Color(0xFF5EF6FF)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp),
                            backgroundColor = Color(0xFFF183E40)
                        ){
                            Row() {
                                Box(modifier = Modifier
                                    .background(color = Color(0xFF5EF6FF))
                                    .height(50.dp)
                                    .width(15.dp)

                                ) {

                                }
                                Text(
                                text = "API REQUEST",
                                fontSize = 20.sp,
                                fontFamily = font,
                                    fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(10.dp),
                                color = Color(0xFF5EF6FF)
                                )
                            }

                        }


                    }//Main Row1
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "HECTOR MANUEL ASTORGA MENDEZ",
                            fontSize = 20.sp,
                            fontFamily = font,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(10.dp),
                            color = Color(0xFF5EF6FF)
                        )
                    }
                }
            }
            /*TopAppBar(
                title = { Text("Top news")}
            )*/
        }
    ) {
        LazyColumn {
            items(news) { new ->
                Card(
                    shape = RoundedCornerShape(0.dp),
                    border = BorderStroke(1.dp, Color(0xFFfe4957)),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { //TODO
                        },
                ) {
                    //Main Row
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(color = Color.Black)
                    ) {
                        Column(
                            Modifier
                                .weight(2f)
                                .padding(vertical = 8.dp)
                                ) {
                            Row(
                                Modifier
                                    .padding(horizontal = 8.dp)
                                    .padding(vertical = 4.dp)
                                    .fillMaxWidth()
                                    .background(Color(0xFFfe4957))
                            ) {
                                androidx.compose.material.Text(
                                    new.title,
                                    fontFamily = font,
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(start = 15.dp),
                                )
                            }//Row1
                            Row(
                                modifier = Modifier
                                    .padding(vertical = 4.dp)
                                    .padding(horizontal = 8.dp)
                            ) {
                                Card(
                                    border = BorderStroke(1.dp, Color.LightGray),
                                    shape = RoundedCornerShape(0.dp),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(color = Color.Transparent)
                                ) {
                                    androidx.compose.material.Text(new.content ?: "",
                                        modifier = Modifier
                                            .padding(start = 15.dp),
                                        color = Color.LightGray,
                                        fontFamily = font,
                                        maxLines = 3)
                                }//Card

                            }//Row2


                        }//Column1
                        Column(
                            Modifier
                                .weight(1f)
                                .padding(5.dp)
                        ) {
                            Image(
                                modifier =
                                Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                                    .border(BorderStroke(2.dp, Color(0xFFfe4957))),
                                    contentScale = ContentScale.Crop,
                                    painter = rememberImagePainter(
                                    data = new.urlToImage,
                                    builder = {
                                        placeholder(R.drawable.placeholder)
                                        error(R.drawable.placeholder)
                                    }
                                ),
                                contentDescription = null,
                                //contentScale = ContentScale.FillWidth
                            )//Image
                        }//Column 2


                    }//Main Row
                }//Card
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun ListPreview() {
    ProjectTheme {
        /*ListScreen(
            navController = rememberNavController(),
            news = arrayListOf(
                News(
                    "Title", "Content", "url"
                ),
                News(
                    "Title 2", "Content 2", "url"
                ),
            )
        )*/
    }
}
