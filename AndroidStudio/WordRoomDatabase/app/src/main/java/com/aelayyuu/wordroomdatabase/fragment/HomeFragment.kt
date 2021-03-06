package com.aelayyuu.wordroomdatabase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aelayyuu.wordroomdatabase.R
import com.aelayyuu.wordroomdatabase.model.Book
import com.aelayyuu.wordroomdatabase.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookViewModel = ViewModelProvider(this)
            .get(BookViewModel::class.java)

        bookViewModel.insert(Book("20","BookName"))
        bookViewModel.allBook.observe (
            viewLifecycleOwner, Observer {
                book ->
                txtBook.text = book.get(0).bookName
            }
        )
    }
}