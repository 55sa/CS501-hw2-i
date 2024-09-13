package com.example.hw2_i

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw2_i.ui.theme.Hw2iTheme
import java.util.Calendar
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw2iTheme {

                //Question 1
//               q1()


                //Question 2
  //              q2()

                //Question 3
                q3()

            }
        }
    }
}

@Composable
fun q1() {
    val opt= listOf(
        "Case A",
        "Case B",
        "Case C",
        "Case D",
        "Case E"
    )

    var msg by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text=msg,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            msg=opt[Random.nextInt(opt.size)]
        }) {
            Text(text="Click to change the word!")
        }
    }
}

@Composable
fun q2() {
    var name by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        TextField(
            value = name,
            onValueChange = {
                name= it
            },
            label={ Text("Enter your name") }
            )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick =
        {
            val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            greeting = when (currentHour) {
                in 5..11 -> "Good Morning, $name!"
                in 12..16 -> "Good Afternoon, $name!"
                in 17..20 -> "Good Evening, $name!"
                else -> "Hello in the middle of the night, $name!"
            }

        }
        ) { Text("submit") }
        Spacer(modifier = Modifier.height(20.dp))
        if(name!=""){
        Text(text=greeting)}
    }

}

@Composable
fun q3() {
    val funFacts = listOf(
        "Case A",
        "Case B",
        "Case C",
        "Case D",
        "Case E"
    )

    var currentFact by remember { mutableStateOf(funFacts[Random.nextInt(funFacts.size)]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = currentFact,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                currentFact = funFacts[Random.nextInt(funFacts.size)]
            },

        ) {
            Text(
                text = "Next Fact",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    Hw2iTheme {

    //  q1()
    //  q2()
        q3()
    }
}