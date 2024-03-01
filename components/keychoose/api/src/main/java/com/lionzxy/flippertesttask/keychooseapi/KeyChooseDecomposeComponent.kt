package com.lionzxy.flippertesttask.keychooseapi

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.core.decompose.ScreenDecomposeComponent

abstract class KeyChooseDecomposeComponent(
    componentContext: ComponentContext
) : ScreenDecomposeComponent(componentContext) {
    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            tabName: String
        ): KeyChooseDecomposeComponent
    }
}