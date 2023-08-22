package com.kukis.cursojetpack.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun CrossFadeAnimationExample() {
    var myComponentType by rememberSaveable {
        mutableStateOf(ComponentType.Text)
    }
    Column {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }
        
        Crossfade(targetState = myComponentType, label = "") {
            when (it) {
                ComponentType.Image -> Icon(imageVector = Icons.Rounded.Stars, contentDescription = "")
                ComponentType.Text -> Text(text = "Soy un componente")
                ComponentType.Box -> Box(modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red))
                ComponentType.Error -> Text(text = "Error")
            }
        }

    }
}

fun getComponentTypeRandom(): ComponentType {
    return when(nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType(){
    Image, Text, Box, Error
}

@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable { mutableStateOf(true) }

    Button(onClick = { isVisible = !isVisible }) {
        Text(text = "Mostrar/Ocultar")
    }
    Spacer(modifier = Modifier.size(50.dp))

    AnimatedVisibility(isVisible, enter = slideInHorizontally(), exit = slideOutHorizontally()) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
        )
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(500),
        label = "",
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize }) {
        AnimatedVisibility (!smallSize) {
            Text(text = "Hello")
        }
    }
}

@Composable
fun ColorAnimationSimple() {
    Column {
        var firstColor by rememberSaveable { mutableStateOf(false) }
        var realColor = if (firstColor) Color.Red else Color.Yellow
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })

        Spacer(modifier = Modifier.size(200.dp))

        var firstColor1 by rememberSaveable { mutableStateOf(false) }
        var showBox by rememberSaveable { mutableStateOf(true) }
        val realColor2 by animateColorAsState(
            targetValue = if (firstColor1) Color.Red else Color.Yellow,
            animationSpec = tween(durationMillis = 2000),
            finishedListener = { showBox = false },
            label = ""
        )
        if (showBox) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { firstColor1 = !firstColor1 })
        }
    }
}