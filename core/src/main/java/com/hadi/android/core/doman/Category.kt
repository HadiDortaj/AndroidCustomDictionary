package com.hadi.android.core.doman

data class Category(
    var id: Long,
    var title: String,
    var relatedWords: List<Word>
)