package legom.handbagshop.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import legom.handbagshop.data.retrofit.MainApi
import legom.handbagshop.domain.entity.Product
import legom.handbagshop.domain.repository.ShopRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ShopRepositoryImpl : ShopRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.112/host/shop/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mainApi = retrofit.create(MainApi::class.java)

    private val productList = MutableLiveData<List<Product>>()

    private val product = MutableLiveData<Product>()


    override suspend fun getProduct(productId: Int): LiveData<Product> {
        updateProduct(productId)
        return product
    }

    override suspend fun getProductList(): LiveData<List<Product>> {
        updateList()
        return productList
    }

    private suspend fun updateProduct(productId: Int){
        product.value = mainApi.getProduct(productId)
    }

    private suspend fun updateList() {
        productList.value = mainApi.getProductList()
    }
}