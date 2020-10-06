package com.hadi.android.custom.dictionary.presenter.utils

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.hadi.android.custom.dictionary.presenter.fragment.addword.TypeSpinnerAdapter

@BindingAdapter("adapter")
fun bindSpinnerAdapter(spinner: Spinner, vararg choiceList: String) {
    spinner.adapter = TypeSpinnerAdapter(spinner.context, choiceList.toList())
}

@BindingAdapter("selectedItem")
fun bindSelectedItem(spinner: Spinner, oldSelectedItem: String?, selectedItem: String) {
    if (spinner.adapter == null || oldSelectedItem == selectedItem || selectedItem.isEmpty()) return
    val adapter = spinner.adapter as TypeSpinnerAdapter
    val selection: Int = adapter.getPosition(selectedItem).let { if (it != -1) it else 0 }
    spinner.setSelection(selection)
}

@InverseBindingAdapter(attribute = "selectedItem", event = "selectedItemChangedListener")
fun bindSelectedItemInverse(spinner: Spinner): String {
    return spinner.selectedItem as String
}

@BindingAdapter("selectedItemChangedListener")
fun bindSelectedItemListener(spinner: Spinner, attrChange: InverseBindingListener) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            attrChange.onChange()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }
}