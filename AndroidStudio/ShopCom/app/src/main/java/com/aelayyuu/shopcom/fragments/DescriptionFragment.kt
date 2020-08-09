package com.aelayyuu.shopcom.fragments

import android.os.Bundle
import android.view.Gravity.apply
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat.apply
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.shopcom.R
import com.aelayyuu.shopcom.adapter.DescriptionAdapter
import com.aelayyuu.shopcom.model.CameraCard
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headerList = ArrayList<CameraCard>()
        headerList.add(CameraCard("Camera","New Product form Leica Brand",R.drawable.sony))
        headerList.add(CameraCard("Camera","New Product form Canon Brand",R.drawable.canon))


      RecyclerDescriptionView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            adapter = DescriptionAdapter(headerList)
        }
    }
}