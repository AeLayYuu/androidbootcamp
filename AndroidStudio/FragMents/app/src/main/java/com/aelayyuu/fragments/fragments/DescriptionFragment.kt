package com.aelayyuu.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.fragments.R
import com.aelayyuu.fragments.adapter.DescriptionAdapter
import com.aelayyuu.fragments.adapter.HeaderAdapter
import com.aelayyuu.fragments.model.Header
import kotlinx.android.synthetic.main.fragment_description.*
import kotlinx.android.synthetic.main.fragment_header.*

class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val descriptionlist = ArrayList<Header>()
        descriptionlist.add(Header("APPLE"))
        descriptionlist.add(Header("Orange"))
        descriptionlist.add(Header("Banana"))
        descriptionlist.add(Header("Grape"))
        descriptionlist.add(Header("Pine Apple"))
        descriptionlist.add(Header("Coconet"))

        RecyclerHeaderView1.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = DescriptionAdapter(descriptionlist)
        }
    }
}