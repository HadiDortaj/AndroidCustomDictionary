package com.hadi.android.custom.dictionary.ui.addword

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.core.doman.Definition
import com.hadi.android.core.doman.Example
import com.hadi.android.custom.dictionary.databinding.ItemDefinitionBinding
import com.hadi.android.custom.dictionary.databinding.ItemExampleBinding

class DefinitionListAdapter(private var definitionList: MutableList<Definition>) :
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

    fun setData(newList: MutableList<Definition>) {
        if (newList === definitionList) throw IllegalArgumentException("list reference passed shouldn't point to old list of this adapter!")
        val oldList = this.definitionList
        val definitionDiffUtilCallback = DefinitionDiffUtilCallback(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(definitionDiffUtilCallback)
        this.definitionList.clear()
        this.definitionList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class DefinitionViewHolder(val binding: ItemDefinitionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.rcvExampleList.itemAnimator = null
            binding.rcvExampleList.adapter = ExampleListAdapter(mutableListOf())
            binding.btnAddExample.setOnClickListener {
                val definition = definitionList[adapterPosition]
                definition.examples.add(produceEmptyExample())
                (binding.rcvExampleList.adapter as ExampleListAdapter).setData(definition.examples.toList())
            }
        }

        fun bind(definition: Definition, definitionNumber: Int) {
            binding.definitionNumber = definitionNumber
            binding.definition = definition
            val exampleListAdapter = binding.rcvExampleList.adapter as ExampleListAdapter
            exampleListAdapter.definitionNumber = definitionNumber
            exampleListAdapter.setData(definition.examples)
        }

        private fun produceEmptyExample(): Example {
            return Example(0, "", "")
        }
    }

    private inner class ExampleListAdapter(private val exampleList: MutableList<Example>) :
        RecyclerView.Adapter<ExampleListAdapter.ExampleViewHolder>() {

        var definitionNumber: Int = -1

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemExampleBinding.inflate(inflater, parent, false)
            return ExampleViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
            val example = exampleList[position]
            holder.bind(example, "$definitionNumber.${position + 1}".toFloat())
        }

        override fun getItemCount(): Int {
            return exampleList.size
        }

        fun setData(newList: List<Example>) {
            if (newList === exampleList) throw IllegalArgumentException("list reference passed shouldn't point to old list of this adapter!")
            val oldList = this.exampleList
            val definitionDiffUtilCallback = ExampleDiffUtilCallback(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(definitionDiffUtilCallback)
            this.exampleList.clear()
            this.exampleList.addAll(newList)
            diffResult.dispatchUpdatesTo(this)
        }

        inner class ExampleViewHolder(val binding: ItemExampleBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(example: Example, exampleNumber: Float) {
                binding.exampleNumber = exampleNumber
                binding.example = example
            }
        }

    }

    private class DefinitionDiffUtilCallback(
        val oldList: List<Definition>,
        val newList: List<Definition>
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

    private class ExampleDiffUtilCallback(
        val oldList: List<Example>,
        val newList: List<Example>
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
