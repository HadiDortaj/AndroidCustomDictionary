package com.hadi.android.custom.dictionary.frameowork.model

import com.hadi.android.custom.dictionary.frameowork.model.DefinitionEntity
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class WordEntity(
    @Id var id: Long = 0,
    var title: String
) {
    lateinit var definitionEntities: ToMany<DefinitionEntity>
}