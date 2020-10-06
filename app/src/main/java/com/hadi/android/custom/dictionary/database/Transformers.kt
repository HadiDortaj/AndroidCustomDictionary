package com.hadi.android.custom.dictionary.database

import com.hadi.android.custom.dictionary.database.model.*
import com.hadi.android.core.doman.Category as CoreCategory
import com.hadi.android.core.doman.Word as CoreWord
import com.hadi.android.core.doman.Definition as CoreDefnition
import com.hadi.android.core.doman.Example as CoreExample

fun CoreCategory.toAppModel(): CategoryEntity {
    return CategoryEntity(id, title)
}

fun CategoryEntity.toCoreModel(): CoreCategory {
    return CoreCategory(id, title)
}

fun CoreExample.toAppModel(): ExampleEntity {
    return ExampleEntity(0, originalExample, translationOrExtraInformation)
}

fun ExampleEntity.toCoreModel(): CoreExample {
    return CoreExample(id, originalExample, translationOrExtraInformation)
}

fun CoreDefnition.toAppModel(): DefinitionEntity {
    return DefinitionEntity(0, definitionText, type).apply {
        exampleEntities.addAll(examples.map { it.toAppModel() })
    }
}

fun DefinitionEntity.toCoreModel(): CoreDefnition {
    return CoreDefnition(id, definitionText, type, exampleEntities.map { it.toCoreModel() })
}

fun CoreWord.toAppModel(): WordEntity {
    return WordEntity(0, title).apply {
        definitionEntities.addAll(definitions.map { it.toAppModel() })
        categoryEntity.target = category.toAppModel()
    }
}

fun WordEntity.toCoreModel(): CoreWord {
    return CoreWord(
        id,
        title,
        categoryEntity.target.toCoreModel(),
        definitionEntities.map { it.toCoreModel() })
}

