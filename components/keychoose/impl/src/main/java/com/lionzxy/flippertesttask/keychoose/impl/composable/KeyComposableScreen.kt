package com.lionzxy.flippertesttask.keychoose.impl.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.lionzxy.flippertesttask.keychoose.impl.config.KeyModel
import kotlinx.collections.immutable.PersistentList

@Composable
fun LockerComposableScreen(
    keys: PersistentList<KeyModel>,
    onKeyClick: (Int) -> Unit
) {

    val keysList = remember(keys) { keys }

    LazyColumn {
        items(
            items = keysList,
            key = { it }) {

        }
    }
}