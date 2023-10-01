package com.example.testnewyork.ui.book_categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testnewyork.data.room.BooksCategoryEntity
import com.example.testnewyork.databinding.ItemCategoryBinding

class CategoriesAdapter(private val categoriesListener: CategoriesListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var categories: List<BooksCategoryEntity> = emptyList()

    fun setCategories(bookCategory: List<BooksCategoryEntity>) {
        categories = bookCategory
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    inner class CategoriesViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: BooksCategoryEntity) {
            val categoryName = category.listName
            val books = category.books
            binding.tvItemCategory.text = categoryName
            binding.itemCategory.setOnClickListener {
                categoriesListener.navigateToBooksList(books)
            }
        }
    }


}