package com.aelayyuu.shopcom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.shopcom.R
import com.aelayyuu.shopcom.fragments.ProductFragment
import com.aelayyuu.shopcom.model.LatestArrivals
import com.aelayyuu.shopcom.model.PopularProducts
import kotlinx.android.synthetic.main.fragment_header.view.*
import kotlinx.android.synthetic.main.fragment_product.view.*

class ProductAdapter (private var productlist : ArrayList<PopularProducts>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindHeader(popularProducts: PopularProducts) {
            itemView.txtheader6.text=popularProducts.nameproduct
            itemView.txtheader7.text=popularProducts.brandproduct
            itemView.txtheader8.text= popularProducts.priceproduct
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activity_header_adapter,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productlist.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindHeader(productlist[position])
    }
}