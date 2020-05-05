package io.indrian.celenganbersama

import android.app.Application
import com.github.ajalt.timberkt.Timber

class CelenganBersamaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}