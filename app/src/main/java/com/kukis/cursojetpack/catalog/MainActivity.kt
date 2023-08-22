package com.kukis.cursojetpack.catalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kukis.cursojetpack.R
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
                    //MyText()
                    //MyTextFiled()
                    //MyTextFileAdvance()
                    /*Column {
                        MyTextFileOutlined()
                    }*//*var myText by remember { mutableStateOf("Kukis") }
                    MyTextFiled1(myText) {myText = it}*/
                    //MyButtomExample()
                    //MyImage()
                    //MyImageAdvance()
                    //MyIcon()
                    //MyProgress()
                    //MyProgressAdvance()
                    //MySwitch()
                    //MyCheckBox()
                    //MyCheckBoxWithText()
                    /*val myOptions = getOptions(title = listOf("Ej1", "Ej2", "Ej3"))
                    Column {
                        myOptions.forEach {
                            MyCheckBoxWithTextCompleted(it)
                        }
                    }*/
                    //MyTriStatusCheckBox()
                    //MyRadioButton()
                    /*var selected by rememberSaveable { mutableStateOf("Kukis") }
                    MyRadioButtonList(selected) { selected = it }*/
                    //MyCard()
                    //MyBadgeBox()
                    //MyDivider()
                    //MyDropDownMenu()
                    //BasciSalder()
                    //AdvanceSlider()
                    /*
                    var show by rememberSaveable { mutableStateOf(false) }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar dialogo")
                        }
                    }
                    MyDialog(
                        show = show,
                        onDismiss = { show = false },
                        onConfirm = { Log.i("kukis", "click") })*/
                    /*var show by rememberSaveable { mutableStateOf(false) }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar dialogo")
                        }
                    }
                    MyCustomDialog(
                        show = show,
                        onDismiss = { show = false } )*/

                    var show by rememberSaveable { mutableStateOf(false) }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar dialogo")
                        }
                    }
                    MyConfirmationDialog(
                        show = show,
                        onDismiss = { show = false } )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyBoxPreview() {
    CursoJetpackTheme {
        //MyText()
        //MyTextFiled()
        //MyTextFileAdvance()
        /*Column {
            MyTextFileOutlined()
        }*//*var myText by remember { mutableStateOf("Kukis") }
        MyTextFiled1(myText) {myText = it}*/
        //MyButtomExample()
        //MyImage()
        //MyImageAdvance()
        //MyIcon()
        //MyProgress()
        //MyProgressAdvance()
        //MySwitch()
        //MyCheckBox()
        //MyCheckBoxWithText()
        /*val myOptions = getOptions(title = listOf("Ej1", "Ej2", "Ej3"))
        Column {
            myOptions.forEach {
                MyCheckBoxWithTextCompleted(it)
            }
        }*/
        //MyTriStatusCheckBox()
        //MyRadioButton()
        /*var selected by rememberSaveable { mutableStateOf("Kukis") }
        MyRadioButtonList(selected) { selected = it }*/
        //MyCard()
        //MyBadgeBox()
        //MyDivider()
        //MyDropDownMenu()
        //BasciSalder()
        //AdvanceSlider()
        /*var show by rememberSaveable { mutableStateOf(false) }
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Button(onClick = { show = true }) {
                Text(text = "Mostrar dialogo")
            }
        }
        MyDialog(
            show = show,
            onDismiss = { show = false },
            onConfirm = { Log.i("kukis", "click") })*/

        /*
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar dialogo")
                        }
                    }
                    MyCustomDialog(
                        show = show,
                        onDismiss = { show = false } )*/

        var show by rememberSaveable { mutableStateOf(false) }
        MyConfirmationDialog(
            show = show,
            onDismiss = { show = false } )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = { Text(text = dessert) },
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    })

            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    Column {
        BadgedBox(
            badge = {
                Text(text = "1")
            }, Modifier.padding(12.dp)
        ) {
            Icon(imageVector = Icons.Rounded.Stars, contentDescription = "icon Start")
        }
    }
}

@Composable
fun MyCard() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            shape = MaterialTheme.shapes.small
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Ejemplo 1")
                Text(text = "Ejemplo 2")
                Text(text = "Ejemplo 3")
            }
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Kukis",
                onClick = { onItemSelected("Kukis") }

            )
            Text(text = "Kukis")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Juan",
                onClick = { onItemSelected("Juan") }

            )
            Text(text = "Juan")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Sebastian",
                onClick = { onItemSelected("Sebastian") }

            )
            Text(text = "Sebastian")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Cadavid",
                onClick = { onItemSelected("Cadavid") }

            )
            Text(text = "Cadavid")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = false,
            enabled = false,
            onClick = { /*TODO*/ },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Magenta
            )
        )

        Text(text = "Ej1")
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            } //ToggleableState.Off
            ToggleableState.Off -> ToggleableState.On
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(title: List<String>): List<CheckInfo> {
    return title.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus })
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(
        Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(true) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Column(Modifier.fillMaxSize()) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red, uncheckedColor = Color.Green, checkmarkColor = Color.Blue
            )
        )
    }
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    Column(Modifier.fillMaxSize()) {
        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Magenta,
                checkedThumbColor = Color.Green,
                checkedTrackColor = Color.Cyan

            )
        )
    }
}

@Composable
fun MyProgressAdvance() {
    var progressBar by rememberSaveable { mutableStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressBar) // Cuando se colcoa 0.5f sicnifica el 50%
        Row(Modifier.fillMaxWidth(), Arrangement.Center, Alignment.CenterVertically) {
            Button(onClick = { progressBar += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progressBar -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator()
            LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp, bottom = 32.dp))
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cambiar")
        }

    }

}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Stars, contentDescription = "Icon start", tint = Color.Red)
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        //modifier = Modifier.clip(RoundedCornerShape(40f))
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.55f
    )
}

@Composable
fun MyButtomExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(Modifier.padding(23.dp)) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta, contentColor = Color.Black
            ),
            border = BorderStroke(5.dp, Color.Red),
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { enabled = false }, enabled = enabled, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Black,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Wenas")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFiled1(text: String, onValueChanged: (String) -> Unit) {

    TextField(value = text, onValueChange = { onValueChanged(it) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFileOutlined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        Modifier.padding(24.dp),
        label = {
            Text(
                text = "Nombre"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Green
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFileAdvance() {
    var myText by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize()) {
        TextField(value = myText, onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        }, label = { Text(text = "Introduce tu nombre") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFiled() {
    var myText by remember { mutableStateOf("Kukis") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto en un ejemplo", color = Color.Blue)
        Text(text = "Esto en un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto en un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto en un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto en un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto en un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto en un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto en un ejemplo", fontSize = 30.sp)
    }
}