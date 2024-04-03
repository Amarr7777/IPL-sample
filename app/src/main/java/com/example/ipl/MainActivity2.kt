package com.example.ipl

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPLTheme {
                val name = intent.getStringExtra("NAME") ?: ""
                val email = intent.getStringExtra("EMAIL") ?: ""
                val phone = intent.getStringExtra("PHONE") ?: ""
                mainScreen(name = name, email = email)

            }
        }
    }
}

@Composable
fun mainScreen(name: String, email: String) {
    var currentFormInput by remember { mutableStateOf(1) }
    var currentMenuSelection by remember { mutableStateOf("") }
    val context = LocalContext.current
    val intent = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iplt20.com/"))
    }
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start) {
                Text(text = name, style = MaterialTheme.typography.titleLarge, color = Color.White)
                Text(text = email, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                }
                IconButton(
                    onClick = {
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp)
                ) {

                    Icon(Icons.Default.Send, contentDescription = "live",tint = Color.White)

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            when (currentFormInput) {
                1 -> playerCard1()
                2 -> playerCard2()
                3 -> playerCard3()
                4 -> playerCard4()
            }
            Row(modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                if (currentFormInput == 1) {
                    next(onNextClicked = { currentFormInput = 2 })
                } else if (currentFormInput == 2) {
                    back(onNextClicked = { currentFormInput = 1 })
                    Spacer(modifier = Modifier.padding(10.dp,0.dp))
                    next(onNextClicked = { currentFormInput = 3 })
                } else if (currentFormInput == 3) {
                    back(onNextClicked = { currentFormInput = 2 })
                    Spacer(modifier = Modifier.padding(10.dp,0.dp))
                    next(onNextClicked = { currentFormInput = 4 })
                } else {
                    back(onNextClicked = { currentFormInput = 3 })
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            menu(currentMenuSelection) { selection ->
                currentMenuSelection = selection
            }

            // Updated the rendering logic based on the currentMenuSelection
            when (currentMenuSelection) {
                "Batsmen" -> batsmen()
                "Bowler" -> bowler()
                else -> {} // Handle default or no selection
            }
        }
    }
}

@Composable
fun playerCard1() {

//    Card(
//        shape = RoundedCornerShape(8.dp),
//        modifier = Modifier
//            .padding(8.dp)
//            .background(Color.White)
//            .fillMaxWidth()
//    ){
    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.rohit),
                contentDescription = "player 1",
                modifier = Modifier.padding(16.dp)
            )
            Column {
                Text(
                    text = "Rohit",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Text(
                    text = "Batsman",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
    }

//}

@Composable
fun playerCard2() {
//    Card(
//        shape = RoundedCornerShape(8.dp),
//        modifier = Modifier
//            .padding(8.dp)
//            .background(Color.White)
//            .fillMaxWidth()
//    ){
    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.dhoni),
                contentDescription = "player 2",
                modifier = Modifier.padding(16.dp)
            )
            Column {
                Text(
                    text = "Dhoni",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Text(
                    text = "Batsman",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
    }

//}

@Composable
fun playerCard3() {

//    Card(
//        shape = RoundedCornerShape(8.dp),
//        modifier = Modifier
//            .padding(8.dp)
//            .background(Color.White)
//            .fillMaxWidth()
//    ){
    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.siraj),
                contentDescription = "player 3",
                modifier = Modifier.padding(16.dp)
            )
            Column {
                Text(
                    text = "Siraj",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Text(
                    text = "Bowler",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
    }

//    }

@Composable
fun playerCard4() {

//    Card(
//        shape = RoundedCornerShape(8.dp),
//        modifier = Modifier
//            .padding(8.dp)
//            .background(Color.White)
//            .fillMaxWidth()
//    ){
    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.jadeja),
                contentDescription = "player 4",
                modifier = Modifier.padding(16.dp)
            )
            Column {
                Text(
                    text = "Jadeja",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Text(
                    text = "Bowler",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
    }

//    }



@Composable
fun next(onNextClicked: () -> Unit) {
        IconButton(
            onClick = onNextClicked,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "live",tint = Color.White)
        }
    }


@Composable
fun back(onNextClicked: () -> Unit) {
    IconButton(
        onClick = onNextClicked,
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "live", tint = Color.White)
    }
}


@Composable
fun menu(currentMenuSelection: String, onMenuSelect: (String) -> Unit ){
    Row(modifier = Modifier
        .padding(5.dp, 0.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Players", color = Color.White)
        PopUpMenu(onMenuSelect = onMenuSelect)

    }
}

@Composable
fun PopUpMenu(onMenuSelect: (String) -> Unit) {
    val context = LocalContext.current
    val options = listOf("Batsmen","Bowler")
    var expanded by remember { mutableStateOf(false) }

    Column {
        IconButton(
            onClick = { expanded = !expanded },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Menu",Modifier.size(60.dp), tint = Color.White)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(text = { Text(text = option) }, onClick = {
//                    Toast.makeText(context, "Pressed $option", Toast.LENGTH_SHORT).show()
                    onMenuSelect(option)
                    expanded = false
                })
            }
        }
    }
}

@Composable
fun batsmen(){
    Column {
        Box(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Mgreen, shape = CircleShape)){
            Text(text = "Rohit", color = Color.White, modifier = Modifier.padding(8.dp))
        }
        Box(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Mgreen, shape = CircleShape)){
            Text(text = "Dhoni", color = Color.White, modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun bowler(){
    Column {

        Box(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Mgreen, shape = CircleShape)){
            Text(text = "Siraj", color = Color.White, modifier = Modifier.padding(8.dp))
        }
        Box(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Mgreen, shape = CircleShape)){
            Text(text = "Jadeja", color = Color.White, modifier = Modifier.padding(8.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    IPLTheme {
        mainScreen(name = "Amar", email = "amar@gmail.com")
    }
}