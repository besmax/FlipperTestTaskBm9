package com.lionzxy.flippertesttask.lockerchoose.api

import com.arkivanov.decompose.ComponentContext
import com.flipperdevices.core.decompose.ScreenDecomposeComponent

abstract class LockerChooseDecomposeComponent(
    componentContext: ComponentContext,
) : ScreenDecomposeComponent(componentContext) {

    abstract fun onLockerClick(tabName:String, lockerNumber: Int)
    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            tabName: String,
            onLockerClick: (String, Int) -> Unit,
        ): LockerChooseDecomposeComponent
    }
}