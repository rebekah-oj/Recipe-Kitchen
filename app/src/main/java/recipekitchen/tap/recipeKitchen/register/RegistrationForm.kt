package recipekitchen.tap.recipeKitchen.register

import androidx.lifecycle.MutableLiveData


data class RegistrationForm(
    var userName: String = "",
    var email: String = "",
    var passWord: String = "",
    var confirmPassword: String = "",
    var gender: String = ""
) {
    val userNameError = MutableLiveData<String>()
    val passWordError = MutableLiveData<String>()
    val confirmPasswordError = MutableLiveData<String>()
    val genderError = MutableLiveData<String>()
}