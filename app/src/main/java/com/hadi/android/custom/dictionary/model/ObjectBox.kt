package com.hadi.android.custom.dictionary.model

import android.content.Context
import com.hadi.android.custom.dictionary.model.entity.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {
    private const val DATABASE_NAME = "database"
    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context)
            .name(DATABASE_NAME)
            .build()
    }
}