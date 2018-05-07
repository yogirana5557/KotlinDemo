package com.android.kotlin

import com.android.kotlin.dagger.TestAppModule


open class TestMainApp : MainApp() {

    override fun initializeGraph() {
        graph = DaggerTestAppComponent.builder().testAppModule(TestAppModule()).build()
    }
}
