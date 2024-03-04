package com.lionzxy.flippertesttask.singleactivity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.arkivanov.decompose.defaultComponentContext
import com.lionzxy.flippertesttask.core.di.ComponentHolder
import com.lionzxy.flippertesttask.core.log.LogTagProvider
import com.lionzxy.flippertesttask.core.log.info
import com.lionzxy.flippertesttask.rootscreen.api.RootDecomposeComponent
import com.lionzxy.flippertesttask.singleactivity.di.SingleActivityComponent
import javax.inject.Inject

class SingleActivity : AppCompatActivity(), LogTagProvider {
    override val TAG = "SingleActivity"

    @Inject
    lateinit var rootDecomposeComponentFactory: RootDecomposeComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentHolder.component<SingleActivityComponent>().inject(this)

        val root = rootDecomposeComponentFactory(
            componentContext = defaultComponentContext()
        )

        window.statusBarColor = ResourcesCompat.getColor(resources, R.color.background, theme)
        window.navigationBarColor = ResourcesCompat.getColor(resources, R.color.accent, theme)

        setContent {
            root.Render()

        }
        info { "Create new activity with hashcode: ${this.hashCode()} " + "and intent $intent" }
    }
}