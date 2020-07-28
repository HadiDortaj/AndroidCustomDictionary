package com.hadi.android.custom.dictionary.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Type(
    @Id
    var id: Long = 0,
    var title : String
)