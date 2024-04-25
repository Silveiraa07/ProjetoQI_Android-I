package com.silveira.projetoqi_boxes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silveira.projetoqi_boxes.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Home()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffF9F1F9)
                ),
                title = {
                    Text("Lista de tarefas")
                },
                actions = {
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(Icons.Default.MoreVert, "Tres pontos", tint = Color.Black)
                    }
                }
            )
        },
    ) { innerPading ->
        LazyColumn(Modifier.fillMaxSize().padding(innerPading)) {
            item {
                GerenCard()
            }
        }
    }
}

@Composable
fun GerenCard() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Lavar Louça",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Row {
                Checkbox(
                    checked = false,
                    onCheckedChange = {}
                )
                IconButton(onClick = {}){
                    Icon(Icons.Default.Delete,"")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Home()
        GerenCard()
    }
}