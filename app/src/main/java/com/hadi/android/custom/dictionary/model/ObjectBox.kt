package com.hadi.android.custom.dictionary.model

import android.content.Context
import com.hadi.android.custom.dictionary.model.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context)
            .build()
    }
}