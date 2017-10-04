package charleston.androidkotlinproject.data.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by charleston.anjos on 03/10/17.
 */
data class Client(
        @SerializedName("CodCliente") var id: Long,
        @SerializedName("NomeFantasia") var name: String
)