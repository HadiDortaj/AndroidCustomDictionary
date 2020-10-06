package com.hadi.android.custom.dictionary.ui.wordlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.custom.dictionary.database.model.WordEntity
import com.hadi.android.custom.dictionary.databinding.ItemWordBinding

class WordListAdapter(private var wordList: MutableList<WordEntity>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWordBinding.inflate(inflater, parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList[position]
        holder.bind(word)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    fun setData(newList: MutableList<WordEntity>) {
        val oldList = this.wordList
        val definitionDiffUtilCallback = DefinitionDiffUtilCallback(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(definitionDiffUtilCallback)
        this.wordList.clear()
        this.wordList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class WordViewHolder(val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(word: WordEntity) {
            binding.word = word
        }
    }

    private class DefinitionDiffUtilCallback(
        val oldList: List<WordEntity>,
        val newList: List<WordEntity>
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
