package com.hadi.android.custom.dictionary.database.model

import androidx.annotation.Keep
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne

@Entity
@Keep
data class WordEntity(
    @Id var id: Long = 0,
    var title: String = ""
) {
    lateinit var definitionEntities: ToMany<DefinitionEntity>
    lateinit var categoryEntity: ToOne<CategoryEntity>
}