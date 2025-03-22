package legom.handbagshop.domain.repository

import androidx.lifecycle.LiveData
import legom.handbagshop.domain.entity.Product

interface ShopRepository {

    suspend fun getProduct(productId: Int): LiveData<Product>

    suspend fun getProductList(): LiveData<List<Product>>
}