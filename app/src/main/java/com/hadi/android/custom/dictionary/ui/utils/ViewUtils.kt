package com.hadi.android.custom.dictionary.ui.utils

import android.view.View

fun View.enable(enable: Boolean) {
    isEnabled = enable
    alpha = if (enable) 1.0f else 0.4f
}