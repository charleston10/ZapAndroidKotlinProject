package charleston.androidkotlinproject.data.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by charleston on 03/10/17.
 */
data class PropertyResponse(
        @SerializedName("Imoveis") var properties: List<Property>
) : Serializable