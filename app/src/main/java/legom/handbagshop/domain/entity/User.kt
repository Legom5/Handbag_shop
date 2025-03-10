package legom.handbagshop.domain.entity

data class User(
    val id: Int,
    val login: String,
    val password: String,
    val name:String,
    val lastName: String,
    val token: String
)
