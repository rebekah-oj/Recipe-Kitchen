package tap.tap.RecipeKitchen.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import tap.tap.RecipeKitchen.model.Result

class SearchRepository {

    private val response = MutableLiveData<Result>()

    val _response: LiveData<Result>
        get() = response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    suspend fun init() {
        getRecipe()
    }

    private suspend fun getRecipe() {
        val getRespone = SearchServiceBuilder.retrofitService.getRecipe()

        coroutineScope.launch {

            try {

                val result = getRecipe()
                response.value = Result(response)
            } catch (e: Exception) {
                response.value = Result(error(" failed to retrieve data"))
            }
        }
    }
}