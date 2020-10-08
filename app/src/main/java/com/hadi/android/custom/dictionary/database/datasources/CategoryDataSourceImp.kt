package com.hadi.android.custom.dictionary.database.datasources

import com.hadi.android.core.data.CategoryDataSource
import com.hadi.android.custom.dictionary.database.model.CategoryEntity
import com.hadi.android.custom.dictionary.database.model.CategoryEntity_
import com.hadi.android.core.doman.Category
import io.objectbox.Box
import io.objectbox.BoxStore
import javax.inject.Inject

class CategoryDataSourceImp @Inject constructor(boxStore: BoxStore) : CategoryDataSource {

    private val box: Box<CategoryEntity> = boxStore.boxFor(CategoryEntity::class.java)

    override suspend fun insert(category: Category): Long {
        val id = box.put(category.toAppModel())
        if (id > 0) category.id = id
        return id
    }

    override suspend fun update(category: Category): Boolean {
        return box.put(category.toAppModel()) > 0
    }

    override suspend fun remove(category: Category): Boolean {
        return box.remove(category.id)
    }

    override suspend fun remove(id: Long): Boolean {
        return box.remove(id)
    }

    override suspend fun contains(id: Long): Boolean {
        return box.contains(id)
    }

    override suspend fun containsTitle(title: String): Boolean {
        return box.query()
            .equal(CategoryEntity_.title, title)
            .build()
            .find()
            .count() > 0
    }

    override suspend fun get(id: Long): Category? {
        return box.get(id).toCoreModel()
    }

    override suspend fun getAll(): List<Category> {
        return box.all.map { category -> category.toCoreModel() }
    }

}