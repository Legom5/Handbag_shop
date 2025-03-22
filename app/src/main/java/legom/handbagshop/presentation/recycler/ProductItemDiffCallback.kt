package legom.handbagshop.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import legom.handbagshop.domain.entity.Product

class ProductItemDiffCallback: DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}