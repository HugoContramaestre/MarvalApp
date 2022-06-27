package com.talentomobile.marvel

import android.app.Application
import com.talentomobile.marvel.di.initDI
import timber.log.Timber

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initDI()

        Timber.plant(Timber.DebugTree())
    }
}