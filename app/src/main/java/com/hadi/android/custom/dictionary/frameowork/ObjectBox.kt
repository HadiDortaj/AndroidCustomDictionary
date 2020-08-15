package com.hadi.android.custom.dictionary.frameowork

import android.content.Context
import com.hadi.android.custom.dictionary.frameowork.model.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {

    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
    }

    fun getInstance(): ObjectBox {
        return this
    }
}