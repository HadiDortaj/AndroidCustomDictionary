package com.hadi.android.custom.dictionary.ui.wordlist

import android.content.Context
import android.graphics.Typeface
import android.text.*
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.core.doman.Word
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.ItemWordBinding

class WordListAdapter(private val wordList: MutableList<Word>) :
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

    fun setData(newList: MutableList<Word>) {
        if (newList === wordList) throw IllegalArgumentException("list reference passed shouldn't point to old list of this adapter!")
        val oldList = this.wordList
        val definitionDiffUtilCallback = DefinitionDiffUtilCallback(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(definitionDiffUtilCallback)
        this.wordList.clear()
        this.wordList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class WordViewHolder(val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context: Context = binding.root.context

        fun bind(word: Word) {
            binding.word = word
            binding.txtWordDefinition.text = getStyledDefinitionsText(word)
        }

        private fun getStyledDefinitionsText(word: Word): CharSequence? {
            val spannable = SpannableStringBuilder("")
            for (definition in word.definitions) {
                val definitionType = definition.type
                spannable.append(definitionType)
                spannable.setSpan(
                    ForegroundColorSpan(ContextCompat.getColor(context, R.color.colorPrimary)),
                    (spannable.length - definitionType.length),
                    spannable.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannable.setSpan(
                    StyleSpan(Typeface.BOLD_ITALIC),
                    (spannable.length - definitionType.length),
                    spannable.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannable.append(" ${definition.definitionText} ")
            }
            return spannable
        }
    }

    private class DefinitionDiffUtilCallback(
        val oldList: List<Word>,
        val newList: List<Word>
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
