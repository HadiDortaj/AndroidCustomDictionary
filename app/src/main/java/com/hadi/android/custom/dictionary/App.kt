package com.hadi.android.custom.dictionary

import android.app.Application
import com.hadi.android.custom.dictionary.model.ObjectBox
import com.hadi.android.custom.dictionary.model.entity.Category
import java.util.*

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)

    }
}