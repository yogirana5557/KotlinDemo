package com.android.kotlin.dagger

import com.android.kotlin.TestMainApp
import com.android.kotlin.activity.MainActivityTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(TestAppModule::class))
interface TestAppComponent : AppComponent {

    fun inject(testMainApp: TestMainApp)

    fun inject(mainActivityTest: MainActivityTest)
}