package com.example.testnewyork.ui.books

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.testnewyork.data.model.Book
import com.example.testnewyork.databinding.FragmentBookBinding
import com.example.testnewyork.ui.base.BaseFragment


class BooksFragment : BaseFragment<FragmentBookBinding>(FragmentBookBinding::inflate) {

    private val booksAdapter = BooksAdapter()

    companion object {
        private const val ARG_PARAM1 = "param"
        fun newInstance(param: List<Book>): Fragment {
            val booksFragment = BooksFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_PARAM1, param as ArrayList)
            booksFragment.arguments = args
            return booksFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val books: List<Book>? = arguments?.getParcelableArrayList(ARG_PARAM1)
        books?.let { booksAdapter.setBooks(it) }
        binding.rvBooks.adapter = booksAdapter
    }


}