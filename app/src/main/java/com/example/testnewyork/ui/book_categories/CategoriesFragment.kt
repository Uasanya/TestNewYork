package com.example.testnewyork.ui.book_categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.testnewyork.data.model.Book
import com.example.testnewyork.databinding.FragmentListBinding
import com.example.testnewyork.ui.base.BaseFragment
import com.example.testnewyork.ui.books.BooksFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate),
    CategoriesListener {

    private val viewModel: CategoriesViewModel by viewModels()
    private val categoriesAdapter: CategoriesAdapter = CategoriesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getBooksCategories()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCategories.adapter = categoriesAdapter
        viewModel.categoriesLiveData.observe(viewLifecycleOwner) { categories ->
            categoriesAdapter.setCategories(categories)
        }
    }

    override fun navigateToBooksList(books: List<Book>) {
        navigate(BooksFragment.newInstance(books))
    }

}