package legom.handbagshop.domain.usecases

import androidx.lifecycle.LiveData
import legom.handbagshop.domain.entity.Product
import legom.handbagshop.domain.repository.ShopRepository

class GetProductUseCase(
    private val repository: ShopRepository
) {

    suspend fun getProduct(productId: Int): LiveData<Product>{
        return repository.getProduct(productId)
    }
}