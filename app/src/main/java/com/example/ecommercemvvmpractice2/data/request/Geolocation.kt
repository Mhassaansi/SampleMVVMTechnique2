package om.example.ecommercemvvmpractice2.data

import com.google.gson.annotations.SerializedName


data class Geolocation (
  @SerializedName("lat"  ) var lat  : String? = null,
  @SerializedName("long" ) var long : String? = null
)