package com.lionzxy.flippertesttask.rootscreen.config

import kotlinx.serialization.Serializable

@Serializable
sealed class RootScreenConfig {

    @Serializable
    data object BottomBar: RootScreenConfig()

    @Serializable
    data class KeyChoose(val tabName: String): RootScreenConfig()
}