package com.kukis.cursojetpack.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kukis.cursojetpack.instagram.login.ui.LoginScreen
import com.kukis.cursojetpack.instagram.login.ui.LoginViewModel
import com.kukis.cursojetpack.ui.theme.CursoJetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(loginViewModel)
                }
            }
        }
    }
}

/*@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyBoxPreview() {
    private val loginViewModel:LoginViewModel by viewModel()
    CursoJetpackTheme {
        LoginScreen(loginViewModel)
    }
}*/