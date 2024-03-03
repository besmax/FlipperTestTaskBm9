package com.lionzxy.flippertesttask.lockerchoose.impl.viewmodel

import com.lionzxy.flippertesttask.core.uilifecycle.DecomposeViewModel
import com.lionzxy.flippertesttask.lockerchoose.api.model.LockerChooseScreenState
import com.lionzxy.flippertesttask.lockerchoose.impl.config.map
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import lionxyz.flippertesttask.database.api.repositories.LockerDbRepository

class LockerViewModel @AssistedInject constructor(
    @Assisted val tabName: String,
    private val lockerDbRepository: LockerDbRepository
) : DecomposeViewModel() {

    private val lockerSet: MutableStateFlow<LockerChooseScreenState> =
        MutableStateFlow(LockerChooseScreenState.Loading)

    init {
        getLockers()
    }

    fun getUiState() = lockerSet.asStateFlow()

    private fun getLockers() {
        viewModelScope.launch {
            val deferred = viewModelScope.async {
                when (tabName) {
                    "Device" -> lockerDbRepository.getAllDevice().map { it.map() }
                        .toPersistentList()

                    "Archive" -> lockerDbRepository.getAllArchive().map { it.map() }
                        .toPersistentList()

                    "Hub" -> lockerDbRepository.getAllHub().map { it.map() }.toPersistentList()
                    else -> lockerDbRepository.getAllDevice().map { it.map() }.toPersistentList()
                }

            }
            lockerSet.value = LockerChooseScreenState.Content(deferred.await())
        }
    }

    @AssistedFactory
    fun interface Factory {
        operator fun invoke(tabName: String): LockerViewModel
    }

}