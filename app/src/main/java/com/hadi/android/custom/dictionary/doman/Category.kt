package com.hadi.android.custom.dictionary.doman

data class Category(
    var id: Long,
    var title: String,
    var relatedWords: List<Word>
)