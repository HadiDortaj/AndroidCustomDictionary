package com.hadi.android.custom.dictionary.database.model

import android.os.Parcelable
import androidx.annotation.Keep
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
@Keep
data class WordEntity(
    @Id var id: Long = 0,
    var title: String = ""
) : Parcelable {
    lateinit var definitionEntities: ToMany<DefinitionEntity>
    lateinit var categoryEntity: ToOne<CategoryEntity>
}