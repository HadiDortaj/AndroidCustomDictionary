package com.hadi.android.custom.dictionary.database.model

import androidx.annotation.Keep
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
@Keep
class ExampleEntity(
    @Id var id: Long = 0,
    var originalExample: String = "",
    var translationOrExtraInformation: String = ""
)