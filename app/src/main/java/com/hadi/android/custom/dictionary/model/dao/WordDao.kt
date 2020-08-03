package com.hadi.android.custom.dictionary.model.dao

import com.hadi.android.custom.dictionary.model.entity.Definition
import com.hadi.android.custom.dictionary.model.entity.Word
import io.objectbox.Box

class WordDao(private val box: Box<Word>, private val definitionDao: Box<Definition>) {
    fun insert(word: Word): Long {
        return box.put(word)
    }

    fun getWord(id: Long): Word? {
        return box.get(id)
    }

    fun update(word: Word) {
        box.put(word)
    }

}
