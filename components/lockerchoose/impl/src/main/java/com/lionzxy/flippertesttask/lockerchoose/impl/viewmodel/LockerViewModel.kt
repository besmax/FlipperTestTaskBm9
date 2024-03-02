package com.lionzxy.flippertesttask.lockerchoose.impl.viewmodel

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.lionzxy.flippertesttask.lockerchoose.impl.config.LockerModel
import kotlinx.collections.immutable.toPersistentSet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import lionxyz.flippertesttask.database.api.repositories.LockerDbRepository
import javax.inject.Inject

class LockerViewModel @Inject constructor(
     private val lockerDbRepository: LockerDbRepository
) : InstanceKeeper.Instance {
    private val lockerSet = MutableStateFlow(
        (0..15).map { LockerModel(it, null) }.toPersistentSet()
    )

    fun getLockers() = lockerSet.asStateFlow()

}