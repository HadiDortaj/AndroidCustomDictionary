package com.hadi.android.custom.dictionary.ui.utils

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.hadi.android.custom.dictionary.R

fun Fragment.showSnackBar(msg: String, duration: Int) {
    val snackBar = Snackbar.make(requireView(), msg, duration)
    snackBar.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.red_600))
    snackBar.setTextColor(ContextCompat.getColor(requireContext(), R.color.white_50))
    snackBar.show()
}

fun Fragment.showSnackBar(msg: Int, duration: Int) {
    showSnackBar(requireContext().resources.getString(msg), duration)
}