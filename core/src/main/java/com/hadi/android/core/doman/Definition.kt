package com.hadi.android.core.doman

import java.io.Serializable

data class Definition(
    var id: Long,
    var definitionText: String,
    var type: String,
    var examples: MutableList<Example>
) : Serializable