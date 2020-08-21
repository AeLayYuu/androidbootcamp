package com.aelayyuu.roomexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.roomexample.R
import com.aelayyuu.roomexample.model.Product_Room
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    private var  mClickListener : ClickListener?=null
    private var products = emptyList<Product_Room>()

    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        lateinit var productRoom: Product_Room

        fun bind(productRoom: Product_Room) {
            this.productRoom=productRoom
            itemView.ProductName.text = productRoom.name
            itemView.ProductID.text= productRoom.id.toString()
            itemView.ProductPrice.text=productRoom.price.toString()
            itemView.ProductQuantity.text=productRoom.quantity.toString()
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(productRoom
            )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       return holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }
    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener= clickListener
    }
    interface ClickListener {
        fun onClick(productRoom: Product_Room)
    }
    fun addProductList(product: List<Product_Room>) {
        this.products = product
        notifyDataSetChanged()
    }
}