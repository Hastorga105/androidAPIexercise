package com.android.project

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.project.ui.theme.ProjectTheme

@Composable
fun TopAppBar(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                Color.Transparent
            ),
        //backgroundColor = Color(0x80000000),


    ) {
        Column {
            Row(modifier = Modifier
                .border(
                    border = BorderStroke(1.dp, Color(0xFFFD4957))
                )
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .background(color = Color.Transparent)
                    .height(60.dp)
                    .width(15.dp)
                    .border(border = BorderStroke(1.dp, Color(0xFFFD4957)))

                ) {

                }
                Text(
                    text = "API REQUEST",
                    fontSize = 30.sp,
                    fontFamily = font,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(9f)
                    ,
                    color = Color(0xFFFD4957)
                )
                    Icon(imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = "",
                        tint = Color(0xFFFD4957),
                        modifier = Modifier
                            .size(40.dp)
                            .weight(1f)
                    )


            }
                Text(
                    text = "HECTOR MANUEL ASTORGA MENDEZ",
                    fontSize = 20.sp,
                    fontFamily = font,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(10.dp),
                    color = Color(0xFF5EF6FF)
                )
            }//Column


        }//Card

        }

//Bottom Menu
@Composable
fun MyBottomNavigationMenu(){
    var selected by remember {
        mutableStateOf(0)
    }
    Card(
        border = BorderStroke(3.dp,Color(0xFF571819)),
        shape = RoundedCornerShape(0.dp)
    ) {
        BottomNavigation(
            backgroundColor = Color(0xfff0F1016),
            contentColor = Color(0xfff45DBE2)
        ) {
            BottomNavigationItem(
                selected = selected == 0,
                onClick = { selected = 0 }, icon={
                    Icon(imageVector = Icons.Default.Home,
                        contentDescription = "Home")
                }, label = { Text(text = "Home")})
            BottomNavigationItem(
                selected = selected == 1,
                onClick = { selected = 1 },
                icon={
                    Icon(imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite")
                }, label = { Text(text = "Fav")})
            BottomNavigationItem(
                selected = selected == 2,
                onClick = { selected = 2 },
                icon={
                    Icon(imageVector = Icons.Default.Person,
                        contentDescription = "Person")
                }, label = { Text(text = "Person")})

        }
    }

}
@Composable
fun MyLoading(){
Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
verticalArrangement = Arrangement.Center) {
    Text(text = "LOADING :)",
        fontFamily = font,
        color = Color(0xFFfe4957),
        fontSize = 50.sp,
        )
    LinearProgressIndicator(
        modifier = Modifier
            .width(300.dp)
            .height(15.dp),
        backgroundColor = Color.Transparent,
        color = Color(0xFFfe4957)
    )
}
}

//Button
@Composable
fun BottomButton(){
    Icon(
        imageVector = Icons.Rounded.Warning,
        contentDescription = "Add",
        tint = Color(0xFFFFFF68),
        modifier = Modifier.padding(10.dp).size(40.dp),)
    Box(

        modifier = Modifier
            .border(border = BorderStroke(1.dp, Color(0xFFFFFF68)))
            //.padding(start = 16.dp)
            .background(color = Color(0xCC2B2B08))
        ,

        ){
        Row(verticalAlignment = Alignment.CenterVertically) {

            Box(modifier = Modifier
                .background(color = Color(0xFFFFFF68))
                .height(50.dp)
                .width(15.dp),
            ) {

            }
            Text(
                text = "UPDATE LIST",
                fontSize = 20.sp,
                fontFamily = font,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(10.dp),
                color = Color(0xFFFFFF68)
            )
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Add",
                tint = Color(0xFFFFFF68),
                modifier = Modifier.padding(10.dp),)
        }//Row
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ProjectTheme {
        //TopAppBar()
        BottomButton()
    }
}

