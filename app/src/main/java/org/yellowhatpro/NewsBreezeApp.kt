package org.yellowhatpro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsBreezeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
    companion object {
        var appContext: NewsBreezeApp? = null
    }
}