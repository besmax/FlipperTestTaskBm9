package com.lionzxy.flippertesttask.lockerchoose.impl.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.core.uilifecycle.viewModelWithFactory
import com.lionzxy.flippertesttask.lockerchoose.api.LockerChooseDecomposeComponent
import com.lionzxy.flippertesttask.lockerchoose.impl.composable.LockerComposableScreen
import com.lionzxy.flippertesttask.lockerchoose.impl.viewmodel.LockerViewModel
import com.squareup.anvil.annotations.ContributesBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class LockerChooseDecomposeComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted private val tabName: String,
    private val lockerViewModelFactory: LockerViewModel.Factory,
    @Assisted  private val onLockerClick: (String, Int) -> Unit,
) : LockerChooseDecomposeComponent(componentContext) {
    override fun onLockerClick(tabName: String, lockerNumber: Int) {
        onLockerClick(tabName, lockerNumber)
    }

    @Composable
    override fun Render() {
        val lockerViewModel = viewModelWithFactory(key = tabName) {
            lockerViewModelFactory(tabName)
        }
        val uiState by lockerViewModel.getUiState().collectAsState()

        Column(
            Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "$tabName tab",
                fontSize = 32.sp,
                textAlign = TextAlign.Start
            )
            LockerComposableScreen(uiState, onLockerClick, tabName)
        }
    }

    @AssistedFactory
    @ContributesBinding(AppGraph::class, LockerChooseDecomposeComponent.Factory::class)
    interface Factory : LockerChooseDecomposeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            tabName: String,
            onLockerClick: (String, Int) -> Unit,
        ): LockerChooseDecomposeComponentImpl
    }
}