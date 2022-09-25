package org.yellowhatpro

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
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