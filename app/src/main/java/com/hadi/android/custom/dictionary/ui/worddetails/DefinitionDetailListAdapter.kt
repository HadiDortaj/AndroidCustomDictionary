package com.hadi.android.custom.dictionary.ui.worddetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.core.doman.Definition
import com.hadi.android.core.doman.Example
import com.hadi.android.custom.dictionary.databinding.ItemDefinitionDetailBinding
import com.hadi.android.custom.dictionary.databinding.ItemExampleDetailBinding

class DefinitionDetailListAdapter(private val definitionList: MutableList<Definition>) :
    RecyclerView.Adapter<DefinitionDetailListAdapter.DefinitionDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDefinitionDetailBinding.inflate(inflater, parent, false)
        return DefinitionDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DefinitionDetailViewHolder, position: Int) {
        val definition = definitionList[position]
        holder.bind(definition)
    }

    override fun getItemCount(): Int {
        return definitionList.size
    }

    fun setData(newList: List<Definition>) {
        if (newList === definitionList) throw IllegalArgumentException("list reference passed shouldn't point to old list of this adapter!")
        this.definitionList.clear()
        this.definitionList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class DefinitionDetailViewHolder(val binding: ItemDefinitionDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.layoutRoot.setOnClickListener {
                binding.rcvDetailExampleList.visibility =
                    if (binding.rcvDetailExampleList.isVisible) View.GONE else View.VISIBLE
            }
        }

        fun bind(definition: Definition) {
            binding.definition = definition
            binding.rcvDetailExampleList.adapter = ExampleDetailListAdapter(definition.examples)
        }

        private inner class ExampleDetailListAdapter(private val exampleList: MutableList<Example>) :
            RecyclerView.Adapter<ExampleDetailListAdapter.ExampleDetailViewHolder>() {

            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): ExampleDetailViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemExampleDetailBinding.inflate(inflater, parent, false)
                return ExampleDetailViewHolder(binding)
            }

            override fun onBindViewHolder(holderDetail: ExampleDetailViewHolder, position: Int) {
                val example = exampleList[position]
                holderDetail.bind(example, position + 1)
            }

            override fun getItemCount(): Int {
                return exampleList.size
            }

            inner class ExampleDetailViewHolder(val binding: ItemExampleDetailBinding) :
                RecyclerView.ViewHolder(binding.root) {

                fun bind(example: Example, number: Int) {
                    binding.number = number
                    binding.example = example
                }
            }

        }

    }

}
