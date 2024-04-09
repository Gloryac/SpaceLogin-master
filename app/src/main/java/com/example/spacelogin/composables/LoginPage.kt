package com.example.spacelogin.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spacelogin.R
import androidx.compose.ui.platform.LocalContext


@Composable
fun LoginPage(navController: NavHostController) {
    val nameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val rememberMe = remember { mutableStateOf(false) }
    val context = LocalContext.current
    var isUsernameFocused = remember { mutableStateOf(false) }
    var isPasswordFocused = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp, start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = context.getString(R.string.sign_in),
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 2.sp),
                fontSize = 30.sp

            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(context.getString(R.string.username), modifier = Modifier.padding(bottom = 8.dp))

                OutlinedTextField(
                    value = nameValue.value,
                    onValueChange = { newValue -> nameValue.value = newValue },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = if (isUsernameFocused.value) Color.Gray else Color.White ),
                        //.border(width = 1.dp, color = if (isUsernameFocused.value) Color.Blue else Color.Gray),
                    shape = RectangleShape,
                    placeholder = { Text(text = context.getString(R.string.your_username)) }
                )
                Text(context.getString(R.string.password), modifier = Modifier.padding(bottom = 8.dp))
                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { newValue -> passwordValue.value = newValue },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = "Toggle password visibility",
                                tint = if (passwordVisibility.value) Color.Black else Color.Gray
                            )
                        }
                    },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                        .background(color = if (isPasswordFocused.value) Color.Gray else Color.White ),
                    shape = RectangleShape,
                    placeholder = { Text(text = context.getString(R.string.your_password)) }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = rememberMe.value,
                            onCheckedChange = { checked -> rememberMe.value = checked }
                        )
                        Text(context.getString(R.string.remember_me))
                    }
                    Text(
                        text = context.getString(R.string.forgot_password),
                        color = Color.Black,
                        modifier = Modifier.clickable(onClick = { /* Handle forgot password */ })
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = { /* Handle login */ },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .background(Color(0xFFFC4484), shape = RoundedCornerShape(8.dp)),

                ) {
                    Text(text = context.getString(R.string.log_in), fontSize = 20.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = context.getString(R.string.dont_have_an_account),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = context.getString(R.string.sign_up),
                        color = Color(0xFFFC4484),
                        modifier = Modifier.clickable(onClick = { navController.navigate("register") })
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}







