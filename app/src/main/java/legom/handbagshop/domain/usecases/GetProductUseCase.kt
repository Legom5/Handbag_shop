package legom.handbagshop.domain.usecases

import legom.handbagshop.domain.entity.Product
import legom.handbagshop.domain.repository.ShopRepository

class GetProductUseCase(
    private val repository: ShopRepository
) {

    fun getProduct(productId: Int): Product{
        return repository.getProduct(productId)
    }
}