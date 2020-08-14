package com.hadi.android.custom.dictionary.frameowork.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class TypeEntity (
    @Id var id: Long,
    var title: String
)