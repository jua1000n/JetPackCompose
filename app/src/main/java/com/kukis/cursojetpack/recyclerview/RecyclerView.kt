package com.kukis.cursojetpack.recyclerview

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kukis.cursojetpack.R
import com.kukis.cursojetpack.recyclerview.model.Superhero
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickView() {
    val context = LocalContext.current
    val superhero: Map<String, List<Superhero>> = getSuperheroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superhero.forEach { (publisher, mySuperHero) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(horizontal = 8.dp),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            items(mySuperHero) { it ->
                ItemHero(superhero = it) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}


@Composable
fun SuperHeroWithSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
        ) {
            items(getSuperheroes()) { it ->
                ItemHero(superhero = it) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showbutton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
                //rvState.firstVisibleItemScrollOffset > 3
            }
        }



        if (showbutton) {
            Button(onClick = {
                coroutinesScope.launch {
                    rvState.animateScrollToItem(0)
                }
            }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Soy un boton")
            }
        }

    }
}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(getSuperheroes()) { it ->
                ItemHero(superhero = it) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        },
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
    )
}

@Composable
fun SuperHeroView() {/*LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) {
            ItemHero(superhero = it)
        }
    }*/
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { it ->
            ItemHero(superhero = it) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            //.width(200.dp)
            .clickable { onItemSelected(superhero) }) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}

fun getSuperheroes(): List<Superhero> {
    return listOf(
        Superhero("Spidermand", "Petter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder  Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
}

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("kukis", "juan", "pedro")
    LazyColumn {
        item { Text(text = "Header") }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "Footer") }
    }
}