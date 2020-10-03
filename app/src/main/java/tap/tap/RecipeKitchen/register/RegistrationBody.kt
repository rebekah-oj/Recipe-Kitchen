package tap.tap.RecipeKitchen.register

import androidx.lifecycle.MutableLiveData

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