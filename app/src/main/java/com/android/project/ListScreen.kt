package com.android.project

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.android.project.model.Data
import com.android.project.ui.theme.ProjectTheme


@Composable
fun ListScreen(viewModel: ListScreenViewModel = hiltViewModel()/*Inyectar viewModel*/) {
    var showList by remember { mutableStateOf(false) }
    Scaffold(
        backgroundColor = Color.Transparent,
        topBar = {
            TopAppBar()
        },
        //bottomBar = { MyBottomNavigationMenu()},
        floatingActionButton = {
            Row(
                Modifier
                    .padding(end = 20.dp)
                    .clickable {
                        showList = false
                        showList = true

                    },
                verticalAlignment = Alignment.CenterVertically

            ) {
                BottomButton()
            }//Row

                               },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
    ) {
        if(showList) {
            val newsList by viewModel.getNews().observeAsState(initial = emptyList())//Obtener Datos
            if(newsList.isEmpty()){
                MyLoading()
            }
            ListContent(newsList)
        }
    }
}
@Composable
fun ListContent(data: List<Data>){
    val iconString = "Icons.Outlined.$data.micon"
    LazyColumn(modifier = Modifier
        .padding(horizontal = 8.dp)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF290F12),
                    Color.Black
                )
            )
        ),) {
        items(data) { new ->
            Card(
                shape = RoundedCornerShape(0.dp),
                border = BorderStroke(1.dp, Color(0xFFfe4957)),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                //Main Row
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.Black),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(modifier = Modifier
                        .background(color = Color(0xFFfe4957))
                        .fillMaxHeight()
                        .width(15.dp)

                    )

                    Column(
                        Modifier
                            .weight(1f)
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        /*Icon(
                            imageVector = Icons.Outlined.Warning,
                            contentDescription = "Add",
                            tint = Color(0xfff45DBE2),
                            modifier = Modifier.size(50.dp),
                        )*/


                        Image(
                            modifier =
                            Modifier
                                .height(200.dp)
                                .width(200.dp),
                            //.border(BorderStroke(2.dp, Color(0xFFfe4957))),
                            contentScale = ContentScale.FillWidth,
                            painter = rememberImagePainter(
                                data = new.urlToImage,
                                builder = {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }
                            ),
                            contentDescription = null,
                            //contentScale = ContentScale.FillWidth
                        )//Image*/
                    }//Column 2

                    Column(
                        Modifier
                            .weight(4f)
                            //.padding(vertical = 8.dp)
                            .background(Color.Transparent)
                    ) {
                        Row(
                            Modifier
                                //.padding(horizontal = 8.dp)
                                //.padding(vertical = 4.dp)
                                .fillMaxWidth()
                                //.background(Color(0xFFfe4957))
                        ) {
                            Text(
                                new.title,
                                fontFamily = font,
                                fontSize = 25.sp,
                                color = Color(0xfff45DBE2),
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    //.padding(start = 15.dp),
                            )
                        }//Row1
                        Row(
                            modifier = Modifier

                                //.padding(horizontal = 8.dp)
                        ) {
                            Text(new.content ?: "",
                            //modifier = Modifier
                                //.padding(start = 15.dp),
                            color = Color(0xFFfe4957),
                            fontFamily = font,
                            fontSize = 20.sp,
                            maxLines = 3)
                            /*
                            Card(
                                border = BorderStroke(1.dp, Color.LightGray),
                                shape = RoundedCornerShape(0.dp),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.Transparent)
                            ) {

                            }//Card*/
                        }//Row2


                    }//Column1



                }//Main Row
            }//Card
        }
    }//LazyColumn
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    ProjectTheme {
        //ListScreen()
        ListContent(
            data = arrayListOf(
                Data(
                    "Title", "Content", "url", "Warning"
                ),
                Data(
                    "Title 2", "Content 2", "url", "Refresh"
                ),
            )
        )
    }
}
