package com.lionzxy.flippertesttask.keychoose.impl.viewmodel

import com.lionzxy.flippertesttask.core.uilifecycle.DecomposeViewModel
import com.lionzxy.flippertesttask.keychoose.impl.config.map
import com.lionzxy.flippertesttask.keychooseapi.model.KeyChooseScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import lionxyz.flippertesttask.database.api.repositories.KeyDbRepository
import javax.inject.Inject

class KeyViewModel @Inject constructor(
    private val keyDbRepository: KeyDbRepository
) : DecomposeViewModel() {

    private val uiState: MutableStateFlow<KeyChooseScreenState> =
        MutableStateFlow(KeyChooseScreenState.Loading)

    init {
        getKeys()
    }

    fun getUiState() = uiState.asStateFlow()

    private fun getKeys() {
        uiState.value = KeyChooseScreenState.Loading
        viewModelScope.launch {
            val keys = keyDbRepository.getAll().map { it.map() }
            uiState.value = KeyChooseScreenState.Content(keys)
        }
    }
}