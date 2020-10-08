package recipekitchen.tap.recipeKitchen.register

import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegistrationBody(
    @Json(name = "data")
    val data: MutableLiveData<RegistrationBody>
) {
    @JsonClass(generateAdapter = true)

    data class Data(
        @Json(name = "address")
        val address: String,
        @Json(name = "email")
        val email: String,
        @Json(name = "gender")
        val gender: String,
        @Json(name = "image")
        val image: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "phone")
        val phone: String
    )
}