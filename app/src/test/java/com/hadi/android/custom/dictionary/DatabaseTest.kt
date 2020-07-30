package com.hadi.android.custom.dictionary

import com.hadi.android.custom.dictionary.model.ObjectBox
import com.hadi.android.custom.dictionary.model.entity.MyObjectBox
import io.objectbox.BoxStore
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class DatabaseTest {

    companion object{
        @JvmStatic
        val DATABASE_DIRECTORY: File =
            File("D:\\dev\\project\\android\\CustomDictionary\\app\\build\\test")
    }

    @Test
    fun should_createDatabase_when_notAlreadyCreated(){
        BoxStore.deleteAllFiles(DATABASE_DIRECTORY)
        MyObjectBox.builder()
            .baseDirectory(DATABASE_DIRECTORY)
            .name(ObjectBox.DATABASE_NAME)
            .build()
        assertTrue(File(DATABASE_DIRECTORY.path + "\\" + ObjectBox.DATABASE_NAME + "\\data.mdb").exists())
    }
}