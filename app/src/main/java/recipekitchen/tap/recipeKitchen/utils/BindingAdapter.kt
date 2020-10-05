package recipekitchen.tap.recipeKitchen.utils

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("error")
    fun showError(textInputLayout: TextInputLayout, errorMessage: String?) {
        errorMessage?.let {
            textInputLayout.error = errorMessage
        }
    }
}