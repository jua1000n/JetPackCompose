package com.kukis.cursojetpack.instagram.login.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kukis.cursojetpack.R

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)

    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        if (isLoading) {
            Box(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

        } else {
            Header(Modifier.align(Alignment.TopEnd))
            Body(Modifier.align(Alignment.Center), loginViewModel)
            Footer(Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        SingUp()
    }
}

@Composable
fun SingUp() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have an account? ",
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5),

            )
        Text(
            text = "Sing Up.",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Space(32)
        Email(email) {
            loginViewModel.onLoginChange(it, password)
        }
        Space(4)
        Password(password) {
            loginViewModel.onLoginChange(email, it)
        }
        ForgotPassword(Modifier.align(Alignment.End))
        Space(16)
        LoginButtom(isLoginEnable, loginViewModel)
        Space(16)
        LoginDivider()
        Space(32)
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Social login fb",
            Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Kukis",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 12.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButtom(loginEnable: Boolean, loginViewModel: LoginViewModel) {
    Button(
        onClick = { loginViewModel.onLoginSelected() },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContentColor = Color.White,
            contentColor = Color.White,
            disabledContainerColor = Color(0xFF78C8F9)
        )
    ) {
        Text(text = "Log In")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onValueChange: (String) -> Unit) {
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        singleLine = true,
        placeholder = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            containerColor = Color(0xFFF0EFEF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color(0xFFC4C4C4)
        ),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "PasswordVisibility")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onValueChange: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Phone number, username or email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF636262),
            containerColor = Color(0xFFF0EFEF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color(0xFFC4C4C4)
        )
    )
}

@Composable
fun Space(long: Int) {
    Spacer(modifier = Modifier.size(long.dp))
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta), contentDescription = "LogoApp", modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        modifier.clickable { activity.finish() })
}
