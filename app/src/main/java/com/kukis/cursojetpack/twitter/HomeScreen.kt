package com.kukis.cursojetpack.twitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kukis.cursojetpack.R

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ImageProfileTwit(Modifier.weight(1f))
            BodyTwit(Modifier.weight(5f))

        }
        Divider(
            Modifier
                .background(Color(0xFF636262))
                .height(0.6.dp)
        )
    }
}

@Composable
fun BodyTwit(modifier: Modifier) {
    var isComment by rememberSaveable { mutableStateOf(false) }
    var isRetweet by rememberSaveable { mutableStateOf(false) }
    var isLike by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Header(Modifier)
        Body()
        Image(modifier = Modifier)
        Actions(
            isComment,
            isRetweet,
            isLike,
            onComment = { isComment = it },
            onRetweet = { isRetweet = it },
            onLike = { isLike = it },
        )

    }
}

@Composable
fun Actions(
    isComment: Boolean,
    isRetweet: Boolean,
    isLike: Boolean,
    onComment: (Boolean) -> Unit,
    onRetweet: (Boolean) -> Unit,
    onLike: (Boolean) -> Unit
) {
    Row(Modifier.padding(vertical = 8.dp)) {
        SocialAction(
            Modifier.weight(1f),
            isSelected = isComment,
            unselectedIconRes = R.drawable.ic_chat,
            selectedIconRes = R.drawable.ic_chat_filled,
            contentDescription = "Comment",
            onClick = { onComment(!isComment) }
        )
        SocialAction(
            Modifier.weight(1f),
            isSelected = isRetweet,
            unselectedIconRes = R.drawable.ic_rt,
            selectedIconRes = R.drawable.ic_rt,
            contentDescription = "Retweet",
            tintSelected = Color.Green,
            onClick = { onRetweet(!isRetweet) }
        )
        SocialAction(
            Modifier.weight(1f),
            isSelected = isLike,
            unselectedIconRes = R.drawable.ic_like,
            selectedIconRes = R.drawable.ic_like_filled,
            contentDescription = "Like",
            tintSelected = Color.Red,
            onClick = { onLike(!isLike) }
        )
    }
}

@Composable
fun SocialAction(
    modifier: Modifier,
    isSelected: Boolean,
    unselectedIconRes: Int,
    selectedIconRes: Int,
    contentDescription: String,
    tintSelected: Color = Color(0xFF636262),
    onClick: () -> Unit
) {
    val iconRes = if (isSelected) selectedIconRes else unselectedIconRes
    val tint = if (isSelected) tintSelected else Color(0xFF636262)

    SocialIcons(
        modifier = modifier.clickable(onClick = {onClick()}),
        icon = {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = contentDescription,
                tint = tint
            )
        },
        isSelected = isSelected
    )
}

@Composable
fun SocialIcons(
    modifier: Modifier,
    icon: @Composable () -> Unit,
    isSelected: Boolean
) {
    val defaultValue = 1
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF636262),
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun Image(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "ImageTwit",
        Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .height(200.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun Body() {
    Column(Modifier.padding(vertical = 5.dp)) {
        Text(
            text = "Descripcion Id w arga sobre dwd \n" + "texto Descripcion larga sobre texto \n" + "Descripcion larga sobre texto \n" + "Descripcion larga sobre texto \n" + "Descripcion larga dw dadsobre texto \n",
            color = Color.White
        )
    }
}

@Composable
fun Header(modifier: Modifier) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Row {
            Text(
                text = "Kukis", color = Color.White, fontWeight = FontWeight.Bold
            )
            Text(
                text = "@__Kukis__",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Color(0xFFB5B5B5)
            )
            Text(text = "4h", color = Color(0xFFB5B5B5))
        }
        Image(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "HeaderDots",
            colorFilter = ColorFilter.tint(Color.White),
            alignment = Alignment.CenterEnd
        )
    }
}

@Composable
fun ImageProfileTwit(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "ImageProfile",
        modifier = modifier.clip(CircleShape)
    )
}
