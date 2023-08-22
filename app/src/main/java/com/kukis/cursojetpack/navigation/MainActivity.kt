package com.kukis.cursojetpack.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kukis.cursojetpack.navigation.model.Routes
import com.kukis.cursojetpack.ui.theme.CursoJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color(0xFF171C28)
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ) {
                        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }
                        composable(
                            Routes.Pantalla4.route,
                            arguments = listOf(navArgument("name") { defaultValue = "Juan" })
                        ) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getString("name").orEmpty()
                            )
                        }
                        composable(
                            Routes.Pantalla5.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyBoxPreview() {
    CursoJetpackTheme {

    }
}