package legom.handbagshop.domain.repository

import legom.handbagshop.domain.entity.Product

interface ShopRepository {

    suspend fun getProduct(productId: Int): Product

    suspend fun getProductList(): List<Product>
}