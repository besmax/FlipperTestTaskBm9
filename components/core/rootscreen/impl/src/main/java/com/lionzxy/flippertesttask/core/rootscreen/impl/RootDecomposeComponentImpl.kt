package com.lionzxy.flippertesttask.core.rootscreen.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.res.ResourcesCompat
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.flipperdevices.core.decompose.DecomposeComponent
import com.lionzxy.flippertesttask.bottombar.BottomBarDecomposeComponent
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.core.uilifecycle.findActivity
import com.lionzxy.flippertesttask.keychooseapi.KeyChooseDecomposeComponent
import com.lionzxy.flippertesttask.rootscreen.config.RootScreenConfig
import com.squareup.anvil.annotations.ContributesBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers

class RootDecomposeComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    private val bottomBarDecomposeComponentFactory: BottomBarDecomposeComponent.Factory,
    private val keyChooseDecomposeComponentFactory: KeyChooseDecomposeComponent.Factory,
) : com.lionzxy.flippertesttask.rootscreen.api.RootDecomposeComponent(componentContext),
    ComponentContext by componentContext {

    private val scope = coroutineScope(Dispatchers.Default)
    private val navigation =
        StackNavigation<RootScreenConfig>()

    private val stack: Value<ChildStack<RootScreenConfig, DecomposeComponent>> =
        childStack(
            source = navigation,
            serializer = RootScreenConfig.serializer(),
            initialConfiguration = RootScreenConfig.BottomBar,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(
        config: RootScreenConfig,
        componentContext: ComponentContext
    ): DecomposeComponent = when (config) {
        is RootScreenConfig.BottomBar -> bottomBarDecomposeComponentFactory(
            componentContext = componentContext,
            onLockerChosen = { tabName, lockerNumber ->
                navigation.push(RootScreenConfig.KeyChoose(tabName, lockerNumber))
            },
        )

        is RootScreenConfig.KeyChoose -> keyChooseDecomposeComponentFactory(
            componentContext,
            config.tabName,
            config.lockerNumber,
        )

    }

    @Composable
    override fun Render() {
        val childStack by stack.subscribeAsState()

        Children(
            modifier = Modifier,
            stack = childStack,
        ) {
            val activity = LocalContext.current.findActivity()
            when (it.configuration) {
                is RootScreenConfig.BottomBar -> {
                    activity.window.statusBarColor = ResourcesCompat.getColor(
                        activity.resources,
                        R.color.background,
                        activity.theme
                    )
                    activity.window.navigationBarColor =
                        ResourcesCompat.getColor(activity.resources, R.color.accent, activity.theme)
                    activity.window.setBackgroundDrawableResource(R.color.background)
                }

                is RootScreenConfig.KeyChoose -> {
                    activity.window.statusBarColor = ResourcesCompat.getColor(
                        activity.resources,
                        R.color.secondAccent,
                        activity.theme
                    )
                    activity.window.navigationBarColor =
                        ResourcesCompat.getColor(
                            activity.resources,
                            R.color.secondAccent,
                            activity.theme
                        )
                    activity.window.setBackgroundDrawableResource(R.color.secondAccent)
                }
            }

            it.instance.Render()
        }
    }

    @AssistedFactory
    @ContributesBinding(
        AppGraph::class,
        com.lionzxy.flippertesttask.rootscreen.api.RootDecomposeComponent.Factory::class
    )
    interface Factory : com.lionzxy.flippertesttask.rootscreen.api.RootDecomposeComponent.Factory {
        override operator fun invoke(
            componentContext: ComponentContext,
        ): RootDecomposeComponentImpl
    }

}