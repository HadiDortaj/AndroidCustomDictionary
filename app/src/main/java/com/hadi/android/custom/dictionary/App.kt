package com.hadi.android.custom.dictionary

import android.app.Application
import com.hadi.android.custom.dictionary.database.ObjectBox
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }

}