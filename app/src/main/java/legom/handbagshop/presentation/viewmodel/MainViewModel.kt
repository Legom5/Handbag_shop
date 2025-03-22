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

class MainViewModel: ViewModel() {

    private val repository = ShopRepositoryImpl

    private val getProductListUseCase = GetProductListUseCase(repository)
    private val getProductUseCase = GetProductUseCase(repository)

    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() =_productList


    fun getProductList(){
        viewModelScope.launch {
            _productList.value = repository.getProductList().value
        }
    }
}