package com.android.kotlin

import android.app.Application
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber

/**
 * Created by yogi.
 */
open class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        JodaTimeAndroid.init(this)
    }
}