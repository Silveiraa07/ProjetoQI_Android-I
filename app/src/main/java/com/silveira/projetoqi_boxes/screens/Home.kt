package com.silveira.projetoqi_boxes.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.silveira.projetoqi_boxes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    var todos = remember { mutableStateListOf<String>() }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffF9F1F9)
                ),
                title = {
                    Text("To-do list")
                },
                actions = {
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(Icons.Default.MoreVert, stringResource(R.string.description_icon_three), tint = Color.Black)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("home_page")
                },
            ) {
                Icon(Icons.Filled.Add, stringResource(R.string.add_button))
            }
        }
    ) { innerPadding ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
            items(todos.size) {
                    key ->
                GerenCard(todos.get(key))
            }
        }
    }
}

@Composable
fun GerenCard(text:String) {
    var checkState by remember { mutableStateOf(false) }
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
                text,
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                style = if(checkState) TextStyle(textDecoration = TextDecoration.LineThrough) else TextStyle.Default
            )
            Row {
                Checkbox(
                    checked = checkState,
                    onCheckedChange = {
                        checkState = !checkState
                    }
                )
                IconButton(onClick = {}){
                    Icon(Icons.Default.Delete, stringResource(R.string.description_icon_trash))
                }
            }
        }
    }
}