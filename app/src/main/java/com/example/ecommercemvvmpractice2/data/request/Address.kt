package om.example.ecommercemvvmpractice2.data

import com.google.gson.annotations.SerializedName


data class Address(
    @SerializedName("city") var city: String? = null,
    @SerializedName("street") var street: String? = null,
    @SerializedName("number") var number: Int? = null,
    @SerializedName("zipcode") var zipcode: String? = null,
    @SerializedName("geolocation") var geolocation: Geolocation? = Geolocation()
)