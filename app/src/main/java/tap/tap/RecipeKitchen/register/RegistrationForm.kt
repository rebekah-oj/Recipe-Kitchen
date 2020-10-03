package tap.tap.RecipeKitchen.register

import androidx.lifecycle.MutableLiveData


data class RegistrationForm(
    var name: String = "",
    var email: String = "",
    var phoneNumber: String = "",
    var address: String = "",
    var gender: String = ""
) {
    val nameError = MutableLiveData<String>()
    val phoneNumberError = MutableLiveData<String>()
    val addressError = MutableLiveData<String>()
    val genderError = MutableLiveData<String>()
}