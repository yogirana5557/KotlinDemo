package com.android.kotlin

import android.app.Application
import com.android.kotlin.dagger.AppComponent
import com.android.kotlin.dagger.AppModule
import com.android.kotlin.dagger.DaggerAppComponent
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber

/**
 * Created by yogi.
 */
open class MainApp : Application() {

    companion object {
        @JvmStatic lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        JodaTimeAndroid.init(this)

        initializeGraph()
    }

    open fun initializeGraph() {
        graph = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        graph.inject(this)
    }
}