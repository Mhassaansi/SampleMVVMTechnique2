package om.example.ecommercemvvmpractice2.data

import com.google.gson.annotations.SerializedName


data class AddUsers(
    @SerializedName("email") var email: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("name") var name: Name? = Name(),
    @SerializedName("address") var address: Address? = Address(),
    @SerializedName("phone") var phone: String? = null
){}