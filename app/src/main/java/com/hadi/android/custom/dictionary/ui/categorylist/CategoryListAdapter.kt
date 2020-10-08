package com.hadi.android.custom.dictionary.ui.categorylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.android.core.doman.Category
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.databinding.ItemCategoryBinding
import java.lang.IllegalArgumentException

class CategoryListAdapter(
    private val categoryList: MutableList<Category>,
    val onCategoryClicked: (Category) -> Unit
) : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding: ItemCategoryBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_category,
                parent,
                false
            )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setData(newList: MutableList<Category>) {
        if (newList === categoryList) throw IllegalArgumentException("list reference passed shouldn't point to old list of this adapter!")
        val oldList = this.categoryList
        val categoryDiffUtilCallback =
            CategoryDiffUtilCallback(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(categoryDiffUtilCallback)
        this.categoryList.clear()
        this.categoryList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class CategoryViewHolder(private val itemCategoryBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemCategoryBinding.root) {

        init {
            itemCategoryBinding.itemRoot.setOnClickListener {
                onCategoryClicked(categoryList[adapterPosition])
            }
        }

        fun bind(category: Category) {
            itemCategoryBinding.category = category
        }

    }

    private class CategoryDiffUtilCallback(
        val oldList: List<Category>,
        val newList: List<Category>
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