package com.hadi.android.custom.dictionary.ui.addword

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.custom.dictionary.databinding.ItemDefinitionBinding
import com.hadi.android.custom.dictionary.database.model.DefinitionEntity

class DefinitionListAdapter(private var definitionList: MutableList<DefinitionEntity>) :
    RecyclerView.Adapter<DefinitionListAdapter.DefinitionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDefinitionBinding.inflate(inflater, parent, false)
        return DefinitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DefinitionViewHolder, position: Int) {
        val definition = definitionList[position]
        holder.bind(definition, position + 1)
    }

    override fun getItemCount(): Int {
        return definitionList.size
    }

    fun setData(newList: MutableList<DefinitionEntity>) {
        val oldList = this.definitionList
        val definitionDiffUtilCallback = DefinitionDiffUtilCallback(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(definitionDiffUtilCallback)
        this.definitionList.clear()
        this.definitionList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class DefinitionViewHolder(val binding: ItemDefinitionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(definition: DefinitionEntity, counter: Int) {
            binding.counter = counter
            binding.definition = definition
        }
    }

    private class DefinitionDiffUtilCallback(
        val oldList: List<DefinitionEntity>,
        val newList: List<DefinitionEntity>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItemPosition == newItemPosition && oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItemPosition == newItemPosition && oldList[oldItemPosition] == newList[newItemPosition]
        }

    }

}
