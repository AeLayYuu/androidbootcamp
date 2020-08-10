package com.aelayyuu.shopcom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.shopcom.R
import com.aelayyuu.shopcom.model.CameraCard
import kotlinx.android.synthetic.main.fragment_description.view.*

class DescriptionAdapter (private var descriptionlist : ArrayList<CameraCard>) : RecyclerView.Adapter<DescriptionAdapter.DescriptionViewHolder>() {
    class DescriptionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindHeader(cameraCard: CameraCard) {
            itemView.txtcamera1.text=cameraCard.labelcard
            itemView.txtcamera2.text=cameraCard.descriptioncard
            itemView.imagedescription.setImageResource(cameraCard.cameracard)  //Important learn it don't lazy

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_description,parent,false)
        return DescriptionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return descriptionlist.size
    }

    override fun onBindViewHolder(holder:DescriptionViewHolder, position: Int) {
        holder.bindHeader(descriptionlist[position])
    }

}