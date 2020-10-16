package com.hadi.android.custom.dictionary.ui.addword

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.hadi.android.custom.dictionary.R

class TypeSpinnerAdapter(context: Context, typeList: List<String>) :
    ArrayAdapter<String>(context, 0, typeList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_spinner_selected, parent, false)
        val txtTitle: TextView = view.findViewById(R.id.txt_definition_type_title)
        txtTitle.text = getItem(position)
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_spinner, parent, false)
        val txtTitle: TextView = view.findViewById(R.id.txt_definition_type_title)
        txtTitle.text = getItem(position)
        return view
    }

}