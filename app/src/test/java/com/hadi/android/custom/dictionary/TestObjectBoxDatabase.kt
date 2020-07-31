package com.hadi.android.custom.dictionary

import android.content.Context
import com.hadi.android.custom.dictionary.model.ObjectBox
import com.hadi.android.custom.dictionary.model.entity.MyObjectBox
import io.objectbox.BoxStore
import java.io.File

class TestObjectBoxDatabase {

    private val DATABASE_DIRECTORY =
        "D:\\dev\\project\\android\\CustomDictionary\\app\\build\\dbtest\\"

    val boxStore: BoxStore

    init {
        BoxStore.deleteAllFiles(File(DATABASE_DIRECTORY))
        boxStore = MyObjectBox.builder()
            .directory(File(DATABASE_DIRECTORY))
            .build()
    }

    fun close() {
        boxStore.let {
            it.close()
        }
    }
}