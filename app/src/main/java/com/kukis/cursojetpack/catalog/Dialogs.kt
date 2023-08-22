package com.kukis.cursojetpack.catalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kukis.cursojetpack.R

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    if(show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDilaog(title = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                var status by rememberSaveable { mutableStateOf("") }
                MyRadioButtonList(status) { status = it }
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(Modifier.align(Alignment.End)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Cancelar")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDilaog("Set backup account")
                AccountItem(email = "Ejemplo1@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Ejemplo2@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
            }
        }
    }
}

//@Preview//(showBackground = true, showSystemUi = true)
@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        /*
        * dismissOnClickOutside Bloquea para que el click por fuera no lo saque
        * dismissOnBackPress Bloquea para que la accion de atras no permita salirse
        * */
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Ejemplo1")
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyTitleDilaog(title: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun MyDialog(
    show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
    if (show) {


        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola, soy una descripción") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm Button")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss Button")
                }
            })
    }
}