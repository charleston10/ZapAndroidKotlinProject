package charleston.androidkotlinproject.data.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by charleston.anjos on 03/10/17.
 */
data class Address(
        @SerializedName("Numero") var number: String,
        @SerializedName("CEP") var zipCode: String,
        @SerializedName("Bairro") var neighborhood: String,
        @SerializedName("Cidade") var city: String,
        @SerializedName("Estado") var state: String,
        @SerializedName("Zona") var zone: String
) : Serializable