package com.lionzxy.flippertesttask.keychoose.impl.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.keychoose.impl.composable.KeyComposableScreen
import com.lionzxy.flippertesttask.keychoose.impl.viewmodel.KeyViewModel
import com.lionzxy.flippertesttask.keychooseapi.KeyChooseDecomposeComponent
import com.squareup.anvil.annotations.ContributesBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Provider

class KeyChooseDecomposeComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted private val tabName: String,
    @Assisted private val lockerNumber: Int,
    @Assisted private val navigateBack: () -> Unit,
    private val keyViewModelProvider: Provider<KeyViewModel>
) : KeyChooseDecomposeComponent(componentContext) {

    private val keyViewModel = instanceKeeper.getOrCreate { keyViewModelProvider.get() }

    @Composable
    override fun Render() {
        val coroutineScope = rememberCoroutineScope()
        val uiState by keyViewModel.getUiState().collectAsState()
        Column(
            Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Selecting a key for the locker #$lockerNumber",
                fontSize = 32.sp,
                textAlign = TextAlign.Start
            )

            KeyComposableScreen(
                lockerNumber = lockerNumber,
                uiState = uiState,
                onKeyClick = { lockerNumber, keyNumber, tabName ->
                    coroutineScope.launch {
                        keyViewModel.setKey(lockerNumber, keyNumber, tabName)
                        delay(200)
                        navigateBack.invoke()
                    }

                },
                tabName = tabName
            )
        }
    }

    @AssistedFactory
    @ContributesBinding(AppGraph::class, KeyChooseDecomposeComponent.Factory::class)
    interface Factory : KeyChooseDecomposeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            tabName: String,
            lockerNumber: Int,
            navigateBack: () -> Unit,
        ): KeyChooseDecomposeComponentImpl
    }

}