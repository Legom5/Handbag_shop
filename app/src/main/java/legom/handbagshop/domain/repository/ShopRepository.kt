package legom.handbagshop.domain.repository

import androidx.lifecycle.LiveData
import legom.handbagshop.domain.entity.Product

interface ShopRepository {

    fun getProduct(productId: Int): Product

    fun getProductList(): LiveData<List<Product>>
}