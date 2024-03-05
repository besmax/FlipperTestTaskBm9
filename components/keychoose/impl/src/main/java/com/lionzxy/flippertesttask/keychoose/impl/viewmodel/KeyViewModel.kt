package com.lionzxy.flippertesttask.keychoose.impl.viewmodel

import com.lionzxy.flippertesttask.core.uilifecycle.DecomposeViewModel
import com.lionzxy.flippertesttask.keychoose.impl.converters.map
import com.lionzxy.flippertesttask.keychooseapi.model.KeyChooseScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import lionxyz.flippertesttask.database.api.repositories.KeyDbRepository
import lionxyz.flippertesttask.database.api.repositories.LockerDbRepository
import javax.inject.Inject

class KeyViewModel @Inject constructor(
    private val keyDbRepository: KeyDbRepository,
    private val lockerDbRepository: LockerDbRepository
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
            val keys = keyDbRepository.getAll(Dispatchers.IO).map { it.map() }
            uiState.value = KeyChooseScreenState.Content(keys)
        }
    }

    fun setKey(lockerNumber: Int, keyNumber: Int, tabName: String) {
        viewModelScope.launch {
            when (tabName) {
                "Device" -> lockerDbRepository.setKeyDevice(lockerNumber, keyNumber, Dispatchers.IO)

                "Archive" -> lockerDbRepository.setKeyArchive(lockerNumber, keyNumber, Dispatchers.IO)

                else -> lockerDbRepository.setKeyHub(lockerNumber, keyNumber, Dispatchers.IO)
            }
        }
    }
}