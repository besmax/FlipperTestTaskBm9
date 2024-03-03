package com.lionzxy.flippertesttask.keychooseapi.model

sealed interface KeyChooseScreenState {
    data object Loading : KeyChooseScreenState
    data class Content(
        val keys: List<KeyModel>
    ) : KeyChooseScreenState
}