package com.example.chapter_8_allminitask.tutorlogin.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.chapter_8_allminitask.R
import com.example.chapter_8_allminitask.ui.theme.Gold


@Composable
fun LoginHomeScreen() {
//    LoginPageScreen()
    SignUpPageScreen()
}

@Composable
fun LandingPageScreen() {

    Surface(color = MaterialTheme.colors.primaryVariant) {

        Box(modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                val path = Path() //path = jalur/jalannya
                val x = size.width
                val y = size.height
                val center = size.center
                path.apply {
                    moveTo(0f, 0f)
                    lineTo(x, 0f)
                    cubicTo(
                        x1 = x,
                        y1 = center.y / 2,
                        x2 = x,
                        y2 = center.y,
                        x3 = 0f,
                        y3 = center.y
                    )

                }
                drawPath(path = path, color = Gold)
            }) {
            Column(
                modifier = Modifier.padding(20.dp)
//            .background(color = MaterialTheme.colors.primary)
            ) {
                Text(
                    text = "Hello",
                    style = MaterialTheme.typography.h1,
                    fontSize = 30.sp,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Welcome bang",
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.size(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.iyah),
                    contentDescription = null,
                    modifier = Modifier.size(34.dp)
                )


            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .wrapContentSize(align = Alignment.BottomCenter)
            ) {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSurface //surface = permukaan
                    )
                ) {
                    Text(text = "Register")
                }

            }
        }

    }
}


@Composable
fun LoginPageScreen() {

    Surface( // surface = Buat bikin background color
        color = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        val (username, onUserNameChange) = remember {
            mutableStateOf("")
        }

        Column {

            Text(
                text = "Login",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = username, onValueChange = onUserNameChange,
                label = { Text(text = "UserName nya mana") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            )
            Spacer(modifier = Modifier.size(16.dp))

            val (password, onPasswordChange) = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = password, onValueChange = onPasswordChange,
                label = { Text(text = "pw bang") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.size(16.dp))

            val (checked, onCheckedChange) = remember {
                mutableStateOf(false)
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Checkbox(checked = checked, onCheckedChange = onCheckedChange)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Remember me")
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Forgot Password")

                }

            }

            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Login")


            }

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)
        ) {
            Text(text = "G punya akun?")
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Sign Up")

            }
        }


    }

}

@Composable
fun SignUpPageScreen() {
    val signUpState = SignUpState()
    Surface(
        color = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = signUpState.firstName,
                    onValueChange = { signUpState.firstNameChenged(it) },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "First Name") }
                )
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    value = signUpState.lastName,
                    onValueChange = { signUpState.lastNameChange(it) },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "Last Name") }
                )


            }

            OutlinedTextField(
                value = signUpState.emailAddress,
                onValueChange = { signUpState.emailAddressChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Email Adress") }
            )
            Spacer(modifier = (Modifier.size(8.dp)))
            OutlinedTextField(
                value = signUpState.password,
                onValueChange = { signUpState.confirmPasswordChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = (Modifier.size(8.dp)))
            OutlinedTextField(
                value = signUpState.confirmPassword,
                onValueChange = { signUpState.confirmPasswordChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Confirm Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .padding(horizontal = 16.dp)
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Checkbox(
                    checked = signUpState.checked,
                    onCheckedChange = { signUpState.checkedChange(it) })
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "Agree with privacy police")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Sign Up")
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.BottomCenter)
            ) {
                Text(text = "Dah ada akunnya bang?")
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Sign in", modifier = Modifier.clickable {

                    },
                    color = MaterialTheme.colors.primary
                )
            }
        }

    }
}


@Preview
@Composable
fun LandingPagePrev() {

    SignUpPageScreen()

}

















