package com.hadi.android.core.doman

import java.io.Serializable

data class Example(
    var id: Long,
    var originalExample: String,
    var extraInformation: String,
) : Serializable