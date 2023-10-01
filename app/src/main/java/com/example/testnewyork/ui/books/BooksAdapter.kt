package com.example.testnewyork.ui.books

import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testnewyork.R
import com.example.testnewyork.data.model.Book
import com.example.testnewyork.databinding.ItemBookBinding
import com.example.testnewyork.ui.util.GlideProvider.setImage


class BooksAdapter() : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    private var books: List<Book> = emptyList()

    fun setBooks(books: List<Book>) {
        this.books = books
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(books[position])
    }

    inner class BooksViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            val context = binding.root.context

            binding.ivImage.setImage(book.imageUrl)
            binding.tvName.text = book.title
            binding.tvDescr.text = context.getString(R.string.description, book.description)
            binding.tvAuthor.text = context.getString(R.string.author, book.author)
            binding.tvPublisher.text = context.getString(R.string.publisher, book.publisher)
            binding.tvRank.text = context.getString(R.string.rank, book.rank)
            binding.tvLink.text = book.url
            Linkify.addLinks(binding.tvLink, Linkify.ALL)

        }
    }
}