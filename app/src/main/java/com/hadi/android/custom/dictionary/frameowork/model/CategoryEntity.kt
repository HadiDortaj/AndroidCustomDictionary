package com.hadi.android.custom.dictionary.frameowork.model

import android.os.Parcelable
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity
@Parcelize
data class CategoryEntity(
    @Id var id: Long = 0,
    var title: String
) : Parcelable {
    lateinit var relatedWordEntities: ToMany<WordEntity>
}