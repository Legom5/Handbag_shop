package legom.handbagshop.domain.usecases

import androidx.lifecycle.LiveData
import legom.handbagshop.domain.entity.Product
import legom.handbagshop.domain.repository.ShopRepository

class GetProductListUseCase(
    private val repository: ShopRepository
) {

    fun getProductList(): LiveData<List<Product>>{
        return repository.getProductList()
    }
}