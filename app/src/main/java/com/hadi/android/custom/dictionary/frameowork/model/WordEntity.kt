package com.hadi.android.custom.dictionary.frameowork.model

import android.os.Parcelable
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class WordEntity(
    @Id var id: Long = 0,
    var title: String
) : Parcelable {
    lateinit var categoryEntity: ToOne<CategoryEntity>
    lateinit var definitionEntities: ToMany<DefinitionEntity>
}