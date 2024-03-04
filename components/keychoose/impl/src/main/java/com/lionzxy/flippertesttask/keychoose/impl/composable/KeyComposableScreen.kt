package com.lionzxy.flippertesttask.keychoose.impl.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.lionzxy.flippertesttask.core.uilifecycle.findActivity
import com.lionzxy.flippertesttask.keychooseapi.model.KeyChooseScreenState
import com.lionzxy.flippertesttask.keychooseapi.model.KeyModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@Composable
fun KeyComposableScreen(
    lockerNumber: Int,
    uiState: KeyChooseScreenState,
    onKeyClick: (Int) -> Unit,
) {

    when (uiState) {
        is KeyChooseScreenState.Loading -> ShowLoading()
        is KeyChooseScreenState.Content -> {
            val keysList = remember(uiState) { uiState.keys.toPersistentList() }
            ShowContent(keysList, onKeyClick)
        }
    }
}

@Composable
fun ShowContent(
    keys: PersistentList<KeyModel>,
    onKeyClick: (Int) -> Unit
    ) {
    LazyColumn {
        items(
            items = keys,
            key = { it.number }
        ) { keyItem ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            )
            Row(Modifier.padding(16.dp)) {
                Text(
                    modifier = Modifier
                        .padding()
                        .weight(1f),
                    text = "Key #${keyItem.number}"
                )
            }
        }
    }
}

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(36.dp),
            color = Color.Black
        )
    }
}