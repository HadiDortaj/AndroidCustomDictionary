package com.hadi.android.core.doman

data class Definition(
    var id: Long,
    var definitionText: String,
    var type : Type,
    var examples : List<Example>
)