package com.kukis.cursojetpack.constraint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kukis.cursojetpack.ui.theme.CursoJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //MyBox()
                    //MyColumn()
                    //MyRow()
                    //MyComplexLayout()
                    MyStateExample()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyStateExample() {

    var counter by rememberSaveable  { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }

}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        MySpace(heightt = 20)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            MySpace(widtht = 30)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) { Text(text = "Ejemplo 3") }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MySpace(widtht: Int = 0, heightt: Int = 0) {
    Spacer(
        modifier = Modifier
            .width(widtht.dp)
            .height(heightt.dp)
    )
}

@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Ejemplo1", Modifier.width(100.dp))
        Text("Ejemplo2", Modifier.width(100.dp))
        Text("Ejemplo3", Modifier.width(100.dp))
        Text("Ejemplo2", Modifier.width(100.dp))
        Text("Ejemplo3", Modifier.width(100.dp))
        Text("Ejemplo2", Modifier.width(100.dp))
        Text("Ejemplo3", Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Cuando usamos el #f se divide lo que pertime ver en la pantalla, entre mas grande el numero, tendra un mayor peso y por tanto
        // usara mas porcentaje
        /*Text("Ejemplo 1", Modifier.background(Color.Red).weight(1f))
        Text("Ejemplo 2", Modifier.background(Color.Blue).weight(3f))
        Text("Ejemplo 3", Modifier.background(Color.Yellow).weight(2f))
        Text("Ejemplo 4", Modifier.background(Color.Green).weight(1f))*/

        Text(
            "Ejemplo 1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text("Ejemplo 2", Modifier.background(Color.Blue))
        Text("Ejemplo 3", Modifier.background(Color.Yellow))
        Text("Ejemplo 4", Modifier.background(Color.Green))

    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .background(Color.Red)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.Center
        ) {
            Text("name asdasdasdd")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyBoxPreview() {
    CursoJetpackTheme {
        //MyBox()
        //MyColumn()
        //MyRow()
        //MyComplexLayout()
        MyStateExample()
    }
}

