package com.hadi.android.custom.dictionary.frameowork.datasource

import com.hadi.android.core.data.CategoryDataSource
import com.hadi.android.custom.dictionary.frameowork.ObjectBox
import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.transformer.toAppModel
import com.hadi.android.custom.dictionary.frameowork.transformer.toCoreModel
import com.hadi.android.core.doman.Category as DomainCategory
import io.objectbox.Box

class CategoryDataSourceImp(objectBox: ObjectBox) : CategoryDataSource {

    private val box: Box<CategoryEntity> = ObjectBox.boxStore.boxFor(
        CategoryEntity::class.java)

    override fun insert(category: DomainCategory): Long {
        return box.put(category.toAppModel())
    }

    override fun update(category: DomainCategory): Boolean {
        return box.put(category.toAppModel()) > 0
    }

    override fun remove(category: DomainCategory): Boolean {
        return box.remove(category.id)
    }

    override fun remove(id: Long): Boolean {
        return box.remove(id)
    }

    override fun contains(id: Long): Boolean {
        return box.contains(id)
    }

    override fun get(id: Long): DomainCategory? {
        return box.get(id).toCoreModel()
    }

    override fun getAll(): List<DomainCategory> {
        return box.all.map { category -> category.toCoreModel() }
    }

}