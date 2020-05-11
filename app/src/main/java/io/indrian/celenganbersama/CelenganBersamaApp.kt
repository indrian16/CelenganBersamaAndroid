package io.indrian.celenganbersama

import android.app.Application
import com.github.ajalt.timberkt.Timber
import io.indrian.celenganbersama.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CelenganBersamaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidContext(applicationContext)
            androidLogger(Level.DEBUG)
            modules(
                listOf(
                    appModule
                )
            )
        }
    }
}