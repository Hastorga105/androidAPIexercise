package com.android.project

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.project.model.News
import com.android.project.ui.theme.ProjectTheme
import dagger.hilt.android.AndroidEntryPoint

object Destinations {
    const val LIST_SCREEN = "LIST_SCREEN"
    const val DETAILS_SCREEN = "DETAILS_SCREEN"
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Destinations.LIST_SCREEN
                            ){
                            composable(Destinations.LIST_SCREEN){
                                ListScreen(navController)
                            }
                            composable("${Destinations.DETAILS_SCREEN}/{newTitle}"){
                                //ATODO
                            }
                        }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
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