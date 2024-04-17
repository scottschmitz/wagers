package com.michiganlabs.wagers

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.michiganlabs.hoverboard.analytics.firebase.CrashlyticsTree
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        setupLogging()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        val crashlyticsEnabled = BuildConfig.ENABLE_CRASHLYTICS
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(crashlyticsEnabled)
        if (crashlyticsEnabled) {
            Timber.plant(CrashlyticsTree())
        }
    }
}
