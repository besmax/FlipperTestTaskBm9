package com.lionzxy.flippertesttask.rootscreen.api

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.core.decompose.DecomposeComponent

abstract class RootDecomposeComponent(
    componentContext: ComponentContext
) : DecomposeComponent() {

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext
        ): RootDecomposeComponent
    }

}