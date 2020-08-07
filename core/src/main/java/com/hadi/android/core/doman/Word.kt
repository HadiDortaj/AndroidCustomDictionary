package com.hadi.android.core.doman

data class Word(
    var id: Long,
    var title: String,
    var definitions: List<Definition>
)