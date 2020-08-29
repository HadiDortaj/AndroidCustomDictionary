package com.hadi.android.custom.dictionary.frameowork.model

import android.os.Parcelable
import com.hadi.android.custom.dictionary.frameowork.model.DefinitionEntity
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity
@Parcelize
data class WordEntity(
    @Id var id: Long = 0,
    var title: String
) : Parcelable {
    lateinit var definitionEntities: ToMany<DefinitionEntity>
}