package com.example.funfacts

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.funfacts.ui.theme.FunFactsTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsTheme {
                ButtonCreate()
            }
        }
    }
}

@Composable
fun ButtonCreate(){
    val myList = listOf("Australia is wider than the moon.",
        "Venus is the only planet to spin clockwise.",
        "Allodoxaphobia is the fear of other people’s opinions.",
        "Human teeth are the only part of the body that cannot heal themselves.",
        "Competitive art used to be an Olympic sport.",
        "The first person processed at Ellis Island was a 15-year-old girl from Ireland.",
        "Google Images was created after Jennifer Lopez wore the green dress at the 2000 Grammys.",
        "Lemons float, but limes sink.",
        "The Eiffel Tower was originally made for Barcelona.",
        "It would take 19 minutes to fall to the center of the Earth."
    )
    var cycle by remember{mutableIntStateOf(Random.nextInt(myList.size))}
    Column(){
    Button(onClick = {cycle = (cycle + 1) % myList.size}){
        Text(text = "Next Fact")
    }
        Text(text = myList[cycle], fontFamily=FontFamily.SansSerif, color = Color.Magenta)

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactsTheme {

    }
}