package com.hadi.android.custom.dictionary.model.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne

@Entity
data class Definition(
    @Id
    var id: Long = 0,
    var definitionText: String
){
    lateinit var type: ToOne<Type>
    lateinit var examples: ToMany<Example>
}