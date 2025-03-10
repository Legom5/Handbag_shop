package legom.handbagshop.domain.entity

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: Category,
    val price: String
)
