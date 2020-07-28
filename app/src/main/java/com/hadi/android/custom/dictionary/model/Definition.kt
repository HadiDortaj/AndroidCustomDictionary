package com.hadi.android.custom.dictionary.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne

@Entity
data class Definition(
    @Id
    var id: Long = 0,
    var definitionText: String,
    var type: ToOne<Type>,
    var examples: ToMany<Example>
)