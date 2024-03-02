package com.lionzxy.flippertesttask.keychoose.impl.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.keychoose.impl.viewmodel.KeyViewModel
import com.lionzxy.flippertesttask.keychooseapi.KeyChooseDecomposeComponent
import com.squareup.anvil.annotations.ContributesBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Provider

class KeyChooseDecomposeComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted private val tabName: String,
    private val keyViewModelProvider: Provider<KeyViewModel>
) : KeyChooseDecomposeComponent(componentContext) {

    private val keyViewModel = instanceKeeper.getOrCreate { keyViewModelProvider.get() }

    @Composable
    override fun Render() {
        Column(
            Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "$tabName tab",
                fontSize = 32.sp,
                textAlign = TextAlign.Start
            )
            TODO("Not yet implemented")
        }
    }

    @AssistedFactory
    @ContributesBinding(AppGraph::class, KeyChooseDecomposeComponent.Factory::class)
    interface Factory : KeyChooseDecomposeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            tabName: String
        ): KeyChooseDecomposeComponentImpl
    }

}