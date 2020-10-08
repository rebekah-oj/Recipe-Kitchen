package recipekitchen.tap.recipeKitchen.repository

class RegistrationRepository {

    /** private val response = MutableLiveData<RegistrationBody>()

    val _response: LiveData<RegistrationBody>
    get() = response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
    viewModelJob + Dispatchers.Main
    )

    init {
    // sendRegistrationResponse()
    }

    /**  private fun sendRegistrationResponse() {
    //  val sendRegistrationDeferred = ServiceBuilder.retrofitService.sendRegistrationAsync()

    coroutineScope.launch {

    try {

    val result = sendRegistrationDeferred.await()
    response.value = RegistrationBody(response)
    } catch (e: Exception) {
    response.value = RegistrationBody(error("Registration failed"))
    }
    }

    }**/**/
}

