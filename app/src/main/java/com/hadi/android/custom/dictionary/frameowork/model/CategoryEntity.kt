package com.hadi.android.custom.dictionary.frameowork.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class CategoryEntity(
    @Id var id: Long = 0,
    var title: String
) {
    lateinit var relatedWordEntities: ToMany<WordEntity>
}