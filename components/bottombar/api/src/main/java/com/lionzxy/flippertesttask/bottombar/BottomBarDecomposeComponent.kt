package com.lionzxy.flippertesttask.bottombar

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.core.decompose.DecomposeComponent

abstract class BottomBarDecomposeComponent : DecomposeComponent() {
    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            onLockerChosen: (String, Int) -> Unit
        ): BottomBarDecomposeComponent
    }
}