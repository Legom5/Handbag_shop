package legom.handbagshop.data.retrofit

import legom.handbagshop.domain.entity.Product
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MainApi {

    @GET("products_list.php")
    suspend fun getProductList(): List<Product>

    @FormUrlEncoded
    @POST("product_item.php")
    suspend fun getProduct(@Field("id") id: Int): Product


}