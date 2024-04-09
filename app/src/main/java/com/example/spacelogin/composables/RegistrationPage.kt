import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spacelogin.R

//@Composable
/*fun RegistrationPage() {
    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(10.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    text = "Create account",
                    fontSize = 30.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Username", modifier = Modifier.padding(bottom = 8.dp))
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it },
                        placeholder = { Text(text = "Your Username") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Text("Email", modifier = Modifier.padding(bottom = 8.dp))
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        placeholder = { Text(text = "Your Email") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Text("Password", modifier = Modifier.padding(bottom = 8.dp))
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
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
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { /* Navigate to login page */ },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(text = "Sign Up", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Already have an account? Log in",
                        modifier = Modifier.clickable(onClick = { /* Navigate to registration page */ })
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    TermsAndConditions()
                }
            }
        }
    }
}*/

@Composable
fun TermsAndConditions() {
    val annotatedString = buildAnnotatedString {
        append("I agree to the ")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            pushStringAnnotation(tag = "terms", annotation = "Terms and Conditions")
            append("Terms and Conditions")
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "terms", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    // Handle click on terms and conditions
                    if (annotation.item == "Terms and Conditions") {
                        // Open terms and conditions
                    }
                }
        }
    )
}


fun focusIndicatorModifier(isFocused:Boolean):Modifier{
    return Modifier.border(
        width = 1.dp,
        color=if (isFocused) Color.Blue else Color.Black
    )
}



@Composable
fun RegistrationPage(navController: NavHostController) {
    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val termsAccepted = remember { mutableStateOf(false) }
    val context = LocalContext.current
    var isUsernameFocused = remember { mutableStateOf(false) }
    var isPasswordFocused = remember { mutableStateOf(false) }
    var isEmailFocused = remember { mutableStateOf(false) }

//    var isFocused = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(10.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    text = context.getString(R.string.create_account),
                    fontSize = 30.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.Start) {
                    Text(context.getString(R.string.username), modifier = Modifier.padding(bottom = 8.dp))
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it },
                        placeholder = { Text(text = context.getString(R.string.your_username)) },
                        singleLine = true,
                        shape = RectangleShape,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = if (isUsernameFocused.value) Color.Gray else Color.White )
                    )

                    Text("Email", modifier = Modifier.padding(bottom = 8.dp))
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        placeholder = { Text(text = context.getString(R.string.your_email)) },
                        singleLine = true,
                        shape = RectangleShape,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = if (isEmailFocused.value) Color.Gray else Color.White )
                    )
                    Text("Password", modifier = Modifier.padding(bottom = 8.dp))
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        placeholder = { Text(text = context.getString(R.string.your_password)) },
                        singleLine = true,
                        shape = RectangleShape,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = if (isPasswordFocused.value) Color.Gray else Color.White ),

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
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = termsAccepted.value,
                            onCheckedChange = { termsAccepted.value = it },
                            colors = CheckboxDefaults.colors(checkedColor = Color.Black)
                        )
                        Text(
                            text = context.getString(R.string.terms_and_conditions),
                            modifier = Modifier.clickable(onClick = { /* Open terms and conditions */ })
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { navController.navigate("login") },
                        //colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFC4484), contentColor = Color.White),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xFFFC4484), shape = RoundedCornerShape(8.dp)),
                        enabled = termsAccepted.value
                    ) {
                        Text(text = context.getString(R.string.sign_up), fontSize = 20.sp, color = Color.White)
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = context.getString(R.string.have_an_account),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Text(
                            text = context.getString(R.string.log_in),
                            color = Color(0xFFFC4484),
                            modifier = Modifier.clickable(onClick = { navController.navigate("login") })
                        )
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }
        }
    }
}






