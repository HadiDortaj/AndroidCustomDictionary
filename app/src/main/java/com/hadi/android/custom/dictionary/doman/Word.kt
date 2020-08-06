package com.hadi.android.custom.dictionary.doman

data class Word(
    var id: Long,
    var title: String,
    var definitions: List<Definition>
)