package com.hadi.android.core.doman

import java.io.Serializable

data class Word(
    var id: Long,
    var title: String,
    var category: Category,
    var definitions: MutableList<Definition>
) : Serializable