package tap.tap.RecipeKitchen.register

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Registration(
    @PrimaryKey val phoneNumber: Int,
    @Json(name = "img_src") val imgSrcUrl: String,
    @ColumnInfo(name = "Name") val Name: String,
    @ColumnInfo(name = "Email") val Email: String,
    @ColumnInfo(name = "Address") val Address: String,
    @ColumnInfo(name = "Gender") val Gender: String
)