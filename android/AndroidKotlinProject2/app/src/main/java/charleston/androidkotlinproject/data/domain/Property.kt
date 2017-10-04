package charleston.androidkotlinproject.data.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by charleston.anjos on 03/10/17.
 */

data class Property(
        @SerializedName("CodImovel") var id: Long,
        @SerializedName("TipoImovel") var type: String,
        @SerializedName("Endereco") var address: Address,
        @SerializedName("PrecoVenda") var price: Double,
        @SerializedName("Dormitorios") var bedroom: Int,
        @SerializedName("Suites") var suit: Int,
        @SerializedName("Vagas") var spaceAvailable: Int,
        @SerializedName("AreaUtil") var totalArea: Double,
        @SerializedName("AreaTotal") var totalAreaUtil: Double,
        @SerializedName("DataAtualizacao") var dateUpdate: Date,
        @SerializedName("Cliente") var client: Client,
        @SerializedName("UrlImagem") var imageUrl: String,
        @SerializedName("SubTipoOferta") var typeOffer: String,
        @SerializedName("SubtipoImovel") var typePropriertie: String
) : Serializable