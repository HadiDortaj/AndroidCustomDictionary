package com.hadi.android.custom.dictionary

import android.app.Application
import com.hadi.android.custom.dictionary.frameowork.ObjectBox

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }

}