package com.hadi.android.custom.dictionary.frameowork.model

import android.os.Parcelable
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity
@Parcelize
data class TypeEntity (
    @Id var id: Long,
    var title: String
): Parcelable