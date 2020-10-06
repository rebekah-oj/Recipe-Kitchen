package tap.tap.RecipeKitchen.model


import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "data")
    val data: MutableLiveData<Result>
) {
    data class Data(
        @SerializedName("calories")
        val calories: Int,
        @SerializedName("carbs")
        val carbs: String,
        @SerializedName("fat")
        val fat: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("imageType")
        val imageType: String,
        @SerializedName("protein")
        val protein: String,
        @SerializedName("title")
        val title: String
    )
}

