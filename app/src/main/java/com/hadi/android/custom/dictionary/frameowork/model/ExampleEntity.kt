package com.hadi.android.custom.dictionary.frameowork.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class ExampleEntity(
    @Id var id: Long,
    var originalExample: String,
    var translationOrExtraInformation: String
)