package tap.tap.RecipeKitchen.register

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    val form = RegistrationForm()

    fun onActivityResult(requestCode: Int, data: Intent?) {

    }

    fun onRegisterClick() {

        if (isFormFilled()) {
            // Register
        } else {
            showError()
        }

    }

    private fun isFormFilled(): Boolean = with(form) {
        name.isNotEmpty() && address.isNotEmpty() && phoneNumber.isNotEmpty() && gender.isNotEmpty()
    }

    private fun showError() = with(form) {
        when {
            name.isEmpty() -> {
                form.nameError.value = "This field is required"
            }
            phoneNumber.isEmpty() -> {
                form.phoneNumberError.value = "This field is required"
            }
            address.isEmpty() -> {
                form.addressError.value = "This field is required"
            }
            gender.isEmpty() -> {
                form.addressError.value = "This field is required"
            }

        }
    }

}
