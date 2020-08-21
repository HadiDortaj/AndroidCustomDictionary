package com.hadi.android.custom.dictionary.frameowork.datasource

import com.hadi.android.core.data.CategoryDataSource
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity_
import com.hadi.android.custom.dictionary.frameowork.transformer.toAppModel
import com.hadi.android.custom.dictionary.frameowork.transformer.toCoreModel
import com.hadi.android.core.doman.Category as DomainCategory
import io.objectbox.Box
import io.objectbox.BoxStore
import javax.inject.Inject

class CategoryDataSourceImp @Inject constructor(boxStore: BoxStore) : CategoryDataSource {

    private val box: Box<CategoryEntity> = boxStore.boxFor(
        CategoryEntity::class.java
    )

    override suspend fun insert(category: DomainCategory): Long {
        return box.put(category.toAppModel())
    }

    override suspend fun update(category: DomainCategory): Boolean {
        return box.put(category.toAppModel()) > 0
    }

    override suspend fun remove(category: DomainCategory): Boolean {
        return box.remove(category.id)
    }

    override suspend fun remove(id: Long): Boolean {
        return box.remove(id)
    }

    override suspend fun contains(id: Long): Boolean {
        return box.contains(id)
    }

    override suspend fun contains(title: String): Boolean {
        return box.query()
            .equal(CategoryEntity_.title, title)
            .build()
            .find()
            .count() > 0
    }

    override suspend fun get(id: Long): DomainCategory? {
        return box.get(id).toCoreModel()
    }

    override suspend fun getAll(): List<DomainCategory> {
        return box.all.map { category -> category.toCoreModel() }
    }

}