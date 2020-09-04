package com.hadi.android.custom.dictionary.frameowork.transformer

import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.model.TypeEntity
import com.hadi.android.core.doman.Category as CoreCategory
import com.hadi.android.core.doman.Type as CoreType

fun CoreCategory.toAppModel(): CategoryEntity {
    val category = CategoryEntity(id, title)
    return category
}

fun CategoryEntity.toCoreModel(): CoreCategory {
    return CoreCategory(id, title)
}

fun TypeEntity.toCoreModel(): CoreType {
    return CoreType(id, title)
}
