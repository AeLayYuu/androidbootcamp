package com.aelayyuu.shopcom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.shopcom.R
import com.aelayyuu.shopcom.adapter.DescriptionAdapter
import com.aelayyuu.shopcom.adapter.ProductAdapter
import com.aelayyuu.shopcom.model.PopularProducts
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headerList = ArrayList<PopularProducts>()
        headerList.add(PopularProducts("Iphone 8 Plus", "Apple","980000 Ks",R.drawable.iphone))
        headerList.add(PopularProducts("GhostBed 11 Inch Cooling Gel Memory Foam ...","GhostBed","325000 Ks",R.drawable.bed))
        headerList.add(PopularProducts("Nintendo Switch - Neon Blue and Red Joy-Com","Nintendo","359000 Ks",R.drawable.nintendo))
        headerList.add(PopularProducts("BELAROI Womens Comf=fy Swing Tunic Short ...","Belaroi","18990 Ks",R.drawable.belaroi))


        RecyclerProductView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            adapter = ProductAdapter(headerList)
        }
    }
}