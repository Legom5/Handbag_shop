package legom.handbagshop.presentation.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import legom.handbagshop.R

class ProductItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tvPrice = view.findViewById<TextView>(R.id.tvPrice)
    val tvName = view.findViewById<TextView>(R.id.tvName)
    val tvCategory = view.findViewById<TextView>(R.id.tvCategory)
    val image = view.findViewById<ImageView>(R.id.imageProduct)
}