package tap.tap.RecipeKitchen.search


import com.google.gson.annotations.SerializedName
import tap.tap.RecipeKitchen.model.Result

data class SearchRecipe(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("totalResults")
    val totalResults: Int
)