package tap.tap.RecipeKitchen.api

import retrofit2.http.GET
import tap.tap.RecipeKitchen.model.Recipe

interface RecipeEndPoints {

    @GET("application/json")
    suspend fun getRecipe(): List<Recipe>
}