package com.hadi.android.custom.dictionary.frameowork.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne

@Entity
data class DefinitionEntity(
    @Id var id: Long = 0,
    var definitionText: String
) {
    lateinit var typeEntity: ToOne<TypeEntity>
    lateinit var exampleEntities: ToMany<ExampleEntity>
}