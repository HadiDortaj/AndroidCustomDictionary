package com.hadi.android.custom.dictionary.presenter.fragment.addword

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.custom.dictionary.frameowork.model.DefinitionEntity

class DefinitionListAdapter(val definitionList: List<DefinitionEntity>) :
    RecyclerView.Adapter<DefinitionListAdapter.DefinitionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
        return DefinitionViewHolder(parent)
    }

    override fun onBindViewHolder(holder: DefinitionViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return definitionList.size
    }

    inner class DefinitionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}
