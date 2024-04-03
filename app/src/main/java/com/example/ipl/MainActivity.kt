package com.example.ipl

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ipl.ui.theme.IPLTheme
import com.example.ipl.ui.theme.Mgreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPLTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(){
    var name by remember { mutableStateOf("") } // State to hold the name entered in formInputs
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    val isFormFilled = name.isNotBlank() && email.isNotBlank() && phone.isNotBlank()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.log),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            formInputs( onNameEntered = { newName -> name = newName },
                onEmailEntered = { newEmail -> email = newEmail },
                onPhoneEntered = { newPhone -> phone = newPhone })
            submit(
                name = name,
                email = email,
                phone = phone,
                isEnabled = isFormFilled
            )
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formInputs(onNameEntered: (String) -> Unit,
               onEmailEntered: (String) -> Unit,
               onPhoneEntered: (String) -> Unit) {
    Column {
        Text(text = "Name", color = Color.White)
        var name by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(width = 1.dp, color = Mgreen, shape = CircleShape) // Set the border color and width
        ){

            TextField(value = name, onValueChange = {
                name = it
                onNameEntered(it) // Invoke the lambda with the updated name
            }, modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black, textColor = Color.White,focusedIndicatorColor = Color.Transparent, // Remove the focused indicator
                    unfocusedIndicatorColor = Color.Transparent))
        }
        Text(text = "Email", color = Color.White)
        var email by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(width = 1.dp, color = Mgreen, shape = CircleShape) // Set the border color and width
        ){

            TextField(value = email, onValueChange = {
                email = it
                onEmailEntered(it)
            }, modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black, textColor = Color.White,focusedIndicatorColor = Color.Transparent, // Remove the focused indicator
                    unfocusedIndicatorColor = Color.Transparent))
        }
        Text(text = "Phone", color = Color.White)
        var phone by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(width = 1.dp, color = Mgreen, shape = CircleShape) // Set the border color and width
        ){

            TextField(value = phone, onValueChange = {
                phone = it
                onPhoneEntered(it)
            }, modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black, textColor = Color.White,focusedIndicatorColor = Color.Transparent, // Remove the focused indicator
                    unfocusedIndicatorColor = Color.Transparent))
        }
        Text(text = "Age", color = Color.White)
        var age by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(width = 1.dp, color = Mgreen, shape = CircleShape) // Set the border color and width
        ){

            TextField(value = age, onValueChange = {
                age = it
                onPhoneEntered(it)
            }, modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black, textColor = Color.White,focusedIndicatorColor = Color.Transparent, // Remove the focused indicator
                    unfocusedIndicatorColor = Color.Transparent))
        }
        Text(text = "Sex", color = Color.White)
        var selectedGender by remember { mutableStateOf("") }
        val genders = listOf("Male", "Female")

        Row(modifier = Modifier
            .padding(5.dp),
            horizontalArrangement = Arrangement.Center) {
            genders.forEach { gender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedGender == gender,
                        onClick = { selectedGender = gender },
                        colors = RadioButtonDefaults.colors(selectedColor = Mgreen, unselectedColor = Color.White)
                    )
                    Text(text = gender, color = Color.White, modifier = Modifier.clickable { selectedGender = gender})
                }
            }
        }
    }
}
@Composable
fun submit(
    name: String,
    email: String,
    phone: String,
    isEnabled: Boolean // Add this parameter to control the visibility or enabled state of the button
) {
    if (isEnabled) { // Only show or enable the button if all fields are filled
        val context = LocalContext.current
        val intent = remember {
            Intent(context, MainActivity2::class.java).apply {
                putExtra("NAME", name)
                putExtra("EMAIL", email)
                putExtra("PHONE", phone)
            }
        }
        Button(
            onClick = { context.startActivity(intent) },
            colors = ButtonDefaults.buttonColors(Mgreen)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Submit", color = Color.Black, modifier = Modifier.padding(10.dp, 0.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "arrow",
                    modifier = Modifier.size(18.dp),
                    tint = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IPLTheme {
        LoginScreen()
    }
}