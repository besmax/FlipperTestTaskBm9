package com.lionzxy.flippertesttask.lockerchoose.impl.composable

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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import com.lionzxy.flippertesttask.lockerchoose.api.model.LockerChooseScreenState
import com.lionzxy.flippertesttask.lockerchoose.api.model.LockerModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@Composable
fun LockerComposableScreen(
    uiState: LockerChooseScreenState
) {
    when (uiState) {
        is LockerChooseScreenState.Content -> {
            val lockerList = remember(uiState) { uiState.lockers.toPersistentList() }
            ShowContent(lockerList)
        }

        is LockerChooseScreenState.Loading -> ShowLoading()
    }
}

@Composable
fun ShowContent(lockerList: PersistentList<LockerModel>) {
    LazyColumn {
        items(
            items = lockerList,
            key = { it.lockerNumber }
        ) { lockerItem ->
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
                    text = "Locker #${lockerItem.lockerNumber}"
                )
                Text(
                    text = if (lockerItem.keyNumber != null) {
                        "Key #${lockerItem.keyNumber}"
                    } else {
                        "Key not found"
                    }
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
        contentAlignment = Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(36.dp),
            color = Black
        )
    }
}