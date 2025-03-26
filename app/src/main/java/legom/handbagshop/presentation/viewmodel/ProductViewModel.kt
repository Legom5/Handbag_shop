package legom.handbagshop.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import legom.handbagshop.data.ShopRepositoryImpl
import legom.handbagshop.domain.entity.Product
import legom.handbagshop.domain.usecases.GetProductListUseCase
import legom.handbagshop.domain.usecases.GetProductUseCase

class ProductViewModel: ViewModel() {

    private val repository = ShopRepositoryImpl

    private val getProductUseCase = GetProductUseCase(repository)


    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product



    fun getProduct(productId: Int){
        viewModelScope.launch {
            _product.value = getProductUseCase.getProduct(productId).value
        }
    }
}