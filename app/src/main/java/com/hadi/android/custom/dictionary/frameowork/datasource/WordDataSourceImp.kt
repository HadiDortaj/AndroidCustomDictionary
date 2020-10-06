package com.hadi.android.custom.dictionary.frameowork.datasource

import com.hadi.android.core.data.WordDataSource
import com.hadi.android.core.doman.Word
import com.hadi.android.custom.dictionary.frameowork.model.WordEntity
import com.hadi.android.custom.dictionary.frameowork.model.WordEntity_
import com.hadi.android.custom.dictionary.frameowork.transformer.toAppModel
import com.hadi.android.custom.dictionary.frameowork.transformer.toCoreModel
import io.objectbox.Box
import io.objectbox.BoxStore
import javax.inject.Inject

class WordDataSourceImp @Inject constructor(boxStore: BoxStore) : WordDataSource {

    private val box: Box<WordEntity> = boxStore.boxFor(
        WordEntity::class.java
    )

    override suspend fun insert(word: Word): Long {
        return box.put(word.toAppModel());
    }

    override suspend fun update(word: Word): Boolean {
        return box.put(word.toAppModel()) > 0
    }

    override suspend fun remove(word: Word): Boolean {
        return box.remove(word.toAppModel())
    }

    override suspend fun remove(id: Long): Boolean {
        return box.remove(id)
    }

    override suspend fun get(id: Long): Word? {
        return box.get(id).toCoreModel()
    }

    override suspend fun getAll(): List<Word> {
        return box.all.map { it.toCoreModel() }
    }

    override suspend fun getAllWordsRelatedToCategory(categoryId: Long): List<Word> {
        return box.query().equal(WordEntity_.categoryEntityId, categoryId).build().find()
            .map { it.toCoreModel() }
    }

}