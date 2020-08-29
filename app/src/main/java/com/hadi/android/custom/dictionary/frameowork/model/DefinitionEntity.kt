package com.hadi.android.custom.dictionary.frameowork.model

import android.os.Parcelable
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity
@Parcelize
data class DefinitionEntity(
    @Id var id: Long = 0,
    var definitionText: String
) : Parcelable{
    lateinit var typeEntity: ToOne<TypeEntity>
    lateinit var exampleEntities: ToMany<ExampleEntity>
}