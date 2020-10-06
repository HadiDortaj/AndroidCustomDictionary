package com.hadi.android.custom.dictionary.presenter.utils

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.notifyObservers() {
    this.value = this.value
}