package com.lionzxy.flippertesttask.keychoose.impl.viewmodel

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import lionxyz.flippertesttask.database.api.repositories.KeyDbRepository
import javax.inject.Inject

class KeyViewModel constructor(
    private val keyDbRepository: KeyDbRepository
) : InstanceKeeper.Instance {
}