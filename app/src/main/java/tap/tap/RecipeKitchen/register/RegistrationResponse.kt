package tap.tap.RecipeKitchen.register

import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegistrationResponse(
    @Json(name = "content")
    val content: Content,
    @Json(name = "error")
    val error: MutableLiveData<RegistrationBody>,
    @Json(name = "success")
    val success: RegistrationResponse
) {
    @JsonClass(generateAdapter = true)
    data class Content(
        @Json(name = "data")
        val `data`: Data
    ) {
        @JsonClass(generateAdapter = true)
        data class Data(
            @Json(name = "address")
            val address: String,
            @Json(name = "dateCreated")
            val dateCreated: String,
            @Json(name = "dateUpdated")
            val dateUpdated: String,
            @Json(name = "email")
            val email: String,
            @Json(name = "gender")
            val gender: String,
            @Json(name = "gps")

            val gps: String,
            @Json(name = "id")
            val id: Int,
            @Json(name = "image")
            val image: String,
            @Json(name = "name")
            val name: String,
            @Json(name = "phone")
            val phone: String,
            @Json(name = "userID")
            val userID: String
        )
    }

    @JsonClass(generateAdapter = true)
    data class Error(
        @Json(name = "message")

        val message: String,
        @Json(name = "status")
        val status: Int
    )

    @JsonClass(generateAdapter = true)
    data class Success(
        @Json(name = "code")
        val code: Int,
        @Json(name = "message")
        val message: String
    )
}