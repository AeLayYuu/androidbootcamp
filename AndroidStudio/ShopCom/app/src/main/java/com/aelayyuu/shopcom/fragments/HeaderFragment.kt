package com.aelayyuu.shopcom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.shopcom.R
import com.aelayyuu.shopcom.adapter.DescriptionAdapter
import com.aelayyuu.shopcom.adapter.HeaderAdapter
import com.aelayyuu.shopcom.model.LatestArrivals
import kotlinx.android.synthetic.main.fragment_header.*


class HeaderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_header, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headerList = ArrayList<LatestArrivals>()
        headerList.add(LatestArrivals("Hyde Park N41015","LOUIS VUITTON","999,99999 Ks",R.drawable.hydepark))
        headerList.add(LatestArrivals("HORNS PINK LONG SLEEVE T SHART","Lady Gaga","72000 Ks",R.drawable.hornspink))


        RecyclerHeaderView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            adapter = HeaderAdapter(headerList)
        }
    }
}