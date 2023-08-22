package com.kukis.cursojetpack.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }, topBar = {
        MyTopAppBar {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(
                    message = "Has pulsado $it",
                    duration = SnackbarDuration.Long,
                    actionLabel = "I nedd help"
                )
            }
        }
    }, bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFAB() }) { }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawer() {
    ModalNavigationDrawer(drawerContent = {

    })
    {}
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Primera opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Segunda opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Tercera opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Cuarta opcion", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyBottomNavigation() {
    NavigationBar {
        NavigationBarItem(selected = false, onClick = { }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }, label = { Text(text = "Home") })
        NavigationBarItem(selected = false, onClick = { }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
        }, label = { Text(text = "Favorite") })
        NavigationBarItem(selected = false, onClick = { }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
        }, label = { Text(text = "Person") })
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MyTopAppBar(onCLickIcon: (String) -> Unit) {
    TopAppBar(title = { Text(text = "Mi primera toolbar") },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            titleContentColor = Color.White, containerColor = Color.Gray
        ),
        navigationIcon = {
            IconButton(onClick = { onCLickIcon("Atras") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {

            IconButton(onClick = { onCLickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { onCLickIcon("Peligro") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        })
}
