package com.hadi.android.custom.dictionary.database.model

import androidx.annotation.Keep
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
@Keep
data class CategoryEntity(
    @Id var id: Long = 0,
    var title: String = ""
)