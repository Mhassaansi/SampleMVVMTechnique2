package om.example.ecommercemvvmpractice2.data

import com.google.gson.annotations.SerializedName


data class Name (
  @SerializedName("firstname" ) var firstname : String? = null,
  @SerializedName("lastname"  ) var lastname  : String? = null
)