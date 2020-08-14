package com.hadi.android.custom.dictionary.frameowork.transformer

import com.hadi.android.custom.dictionary.frameowork.model.CategoryEntity
import com.hadi.android.custom.dictionary.frameowork.model.TypeEntity
import com.hadi.android.core.doman.Definition as CoreDefinition
import com.hadi.android.core.doman.Example as CoreExample
import com.hadi.android.core.doman.Type as CoreType
import com.hadi.android.core.doman.Word as CoreWord
import com.hadi.android.core.doman.Category as CoreCategory

fun CoreCategory.toAppModel(): CategoryEntity {
    val category =
        CategoryEntity(
            id,
            title
        )
    return category
}

fun CategoryEntity.toCoreModel(): CoreCategory {
    return CoreCategory(
        id,
        title,
        relatedWordEntities.toList().map { word ->
            CoreWord(
                word.id,
                word.title,
                word.definitionEntities.toList().map { definition ->
                    CoreDefinition(
                        definition.id,
                        definition.definitionText,
                        definition.typeEntity.target.toCoreModel(),
                        definition.exampleEntities.toList().map { example ->
                            CoreExample(
                                example.id,
                                example.originalExample,
                                example.translationOrExtraInformation
                            )
                        }
                    )
                })
        })
}

fun TypeEntity.toCoreModel(): CoreType {
    return CoreType(id, title)
}
