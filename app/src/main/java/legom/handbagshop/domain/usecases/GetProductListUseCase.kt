package legom.handbagshop.domain.usecases

import legom.handbagshop.domain.entity.Product
import legom.handbagshop.domain.repository.ShopRepository

class GetProductListUseCase(
    private val repository: ShopRepository
) {

    suspend fun getProductList(): List<Product>{
        return repository.getProductList()
    }
}