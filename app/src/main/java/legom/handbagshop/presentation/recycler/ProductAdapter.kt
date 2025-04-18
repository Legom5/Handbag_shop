package legom.handbagshop.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import legom.handbagshop.R
import legom.handbagshop.domain.entity.Product

class ProductAdapter : ListAdapter<Product, ProductItemViewHolder>(ProductItemDiffCallback()) {

    var onProductItemClickListener: ((Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        val productItem = getItem(position)
        holder.tvPrice.text = "${productItem.price} рублей"
        holder.tvName.text = productItem.title
        holder.tvCategory.text = productItem.category
        Picasso.get().load(productItem.imageUrl).into(holder.image)
        holder.view.setOnClickListener{
            onProductItemClickListener?.invoke(productItem.id)
        }

    }


}