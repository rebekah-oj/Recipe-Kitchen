package tap.tap.RecipeKitchen.register

import kotlinx.coroutines.Deferred
import me.tap.rema.data.model.Registration
import me.tap.rema.data.model.RegistrationBody
import me.tap.rema.data.model.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EndPoints {

    @GET("1/club/")
    fun getRegistrations(): Call<Registration>


    @POST("create/user")
    suspend fun sendRegistration(
        @Body body: RegistrationBody
    ): Deferred<RegistrationResponse>

    fun sendRegistrationAsync(): Deferred<RegistrationResponse>

}