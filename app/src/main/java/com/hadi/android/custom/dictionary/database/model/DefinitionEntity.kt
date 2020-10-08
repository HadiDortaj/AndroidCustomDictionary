package com.hadi.android.custom.dictionary.database.model

import androidx.annotation.Keep
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
@Keep
data class DefinitionEntity(
    @Id var id: Long = 0,
    var definitionText: String = "",
    var type: String = ""
) {
    lateinit var exampleEntities: ToMany<ExampleEntity>
}