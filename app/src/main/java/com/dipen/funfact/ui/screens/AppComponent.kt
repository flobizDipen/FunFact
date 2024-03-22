package com.dipen.funfact.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dipen.funfact.R
import com.dipen.funfact.Utility

@Composable
fun TopBar(textValue: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = textValue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.height(40.dp),
            painter = painterResource(R.drawable.img_whatsapp),
            contentDescription = "My logo"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("Hi there")
}

@Composable
fun TextComponent(textInput: String, textSize: TextUnit, textColor: Color = Color.Black) {
    Text(
        text = textInput,
        fontSize = textSize,
        color = textColor,
        fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent("Hi there", 20.sp)
}

@Composable
fun TextFieldComponent(
    onTextChange: (name: String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChange.invoke(it)
        },
        placeholder = {
            Text(
                text = "Enter your name",
                fontSize = 18.sp
            )
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent {
    }
}

@Composable
fun AnimalCard(image: Int, selected: Boolean, animalSelected: (animalName: String) -> Unit) {

    val localFocusManager = LocalFocusManager.current
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp).clickable {
                localFocusManager.clearFocus()
                animalSelected.invoke(if (image == R.drawable.img_cat) "CAT" else "DOG")
            },
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Black else Color.Transparent,
                    shape = RoundedCornerShape(8.dp),
                )
        ) {
            Image(
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(16.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = image),
                contentDescription = "Animal Image",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalCardPreview() {
    AnimalCard(R.drawable.img_cat, true) {

    }
}

@Composable
fun ButtonComponent(
    goToDetailScreen: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailScreen()
        }) {
        TextComponent(
            textInput = "Go to Details Screen",
            textSize = 18.sp,
            textColor = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview() {
    ButtonComponent() {
    }
}

@Composable
fun TextWithShadow(value: String) {
    val offset = Offset(1f, 2f)
    Text(
        text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(
                color = Utility.generateRandomColor(),
                offset = offset,
                blurRadius = 2f
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextWithShadowPreview() {
    TextWithShadow("Dog Lover")
}

@Composable
fun FactComposable(value: String) {
    Card(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp, 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_quotes),
                contentDescription = "Quote Image"
            )
            Spacer(modifier = Modifier.size(24.dp))
            TextWithShadow(value = value)
            Spacer(modifier = Modifier.size(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_quotes),
                contentDescription = "Quote Image",
                modifier = Modifier.rotate(180f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FactComposablePreview() {
    FactComposable("Dog Lover")
}