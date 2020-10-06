package com.hadi.android.custom.dictionary.database.model

import android.os.Parcelable
import androidx.annotation.Keep
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
@Keep
class ExampleEntity(
    @Id var id: Long = 0,
    var originalExample: String = "",
    var translationOrExtraInformation: String = ""
): Parcelable