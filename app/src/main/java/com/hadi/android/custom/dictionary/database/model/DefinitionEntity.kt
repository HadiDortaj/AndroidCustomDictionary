package com.hadi.android.custom.dictionary.database.model

import android.os.Parcelable
import androidx.annotation.Keep
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
@Keep
data class DefinitionEntity(
    @Id var id: Long = 0,
    var definitionText: String = "",
    var type: String = ""
) : Parcelable {
    lateinit var exampleEntities: ToMany<ExampleEntity>
}