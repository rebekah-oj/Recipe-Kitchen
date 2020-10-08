package recipekitchen.tap.recipeKitchen.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    val form = RegistrationForm()

    fun onRegisterClick() {

        if (isFormFilled()) {
            // Register
        } else {
            showError()
        }

    }

    private fun isFormFilled(): Boolean = with(form) {
        userName.isNotEmpty() && confirmPassword.isNotEmpty() && passWord.isNotEmpty() && gender.isNotEmpty()
    }

    private fun showError() = with(form) {
        when {
            userName.isEmpty() -> {
                form.userNameError.value = "This field is required"
            }
            passWord.isEmpty() -> {
                form.passWordError.value = "This field is required"
            }
            confirmPassword.isEmpty() -> {
                form.confirmPasswordError.value = "This field is required"
            }
            gender.isEmpty() -> {
                form.genderError.value = "This field is required"
            }

        }
    }

}
