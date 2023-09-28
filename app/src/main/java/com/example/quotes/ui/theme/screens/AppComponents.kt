package com.example.quotes.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.R

@Composable
fun TopBar(value: String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "tractor")

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar("hi there")
}

@Composable
fun TextComponent(textValue: String, textSize: TextUnit, colorValue: Color = Color.Black
){
    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent("My Application",24.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(name:String,
                       onTextChanged : (name:String)->Unit
){
    //var currentValue by remember{mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier= Modifier.fillMaxWidth(),
        //value = currentValue,
        value = name,
        onValueChange = {
         //   currentValue = it
            onTextChanged(it)},
        placeholder = { Text(text = "Enter your Name", fontSize = 18.sp)},
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions{localFocusManager.clearFocus()}
        )
}

@Composable
fun MyCard(image: Int,
           selected: Boolean,
             onGameSelected:(gameName:String)->Unit){
    Card (
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        val localFocusManager = LocalFocusManager.current
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 2.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val imageSelected =
                            if (image == R.drawable.ic_launcher_background) "Basket Ball" else "Foot Ball"
                        onGameSelected(imageSelected)
                        localFocusManager.clearFocus()
                    },
                painter = painterResource(id = image),
                contentDescription = "Basket ball"
            )
        }
    }
}

@Composable
fun MyButtonComponent(buttonText: String,
                      onClickAction : (String) -> Unit){
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = {
             onClickAction(buttonText) })
    {
        TextComponent(textValue = buttonText, textSize = 18.sp, colorValue = Color.White)
    }

}