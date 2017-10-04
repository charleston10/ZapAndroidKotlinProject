package charleston.androidkotlinproject.data.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by charleston.anjos on 04/10/17.
 */
data class PropertyDetail(
        @SerializedName("CodImovel") var id: Long,
        @SerializedName("TipoImovel") var type: String,
        @SerializedName("Endereco") var address: Address,
        @SerializedName("PrecoVenda") var price: Double,
        @SerializedName("PrecoCondominio") var priceCondominium: Double,
        @SerializedName("Dormitorios") var bedroom: Int,
        @SerializedName("Suites") var suit: Int,
        @SerializedName("Vagas") var spaceAvailable: Int,
        @SerializedName("AreaUtil") var totalArea: Double,
        @SerializedName("AreaTotal") var totalAreaUtil: Double,
        @SerializedName("DataAtualizacao") var dateUpdate: Date,
        @SerializedName("Cliente") var client: Client,
        @SerializedName("UrlImagem") var imageUrl: String,
        @SerializedName("SubTipoOferta") var typeOffer: String,
        @SerializedName("SubtipoImovel") var typeProperty: String,
        @SerializedName("Observacao") var description: String,
        @SerializedName("InformacoesComplementares") var information: String,
        @SerializedName("Fotos") var images: List<String>,
        @SerializedName("Caracteristicas") var characteristics: List<String>,
        @SerializedName("CaracteristicasComum") var characteristicsFeatures: List<String>
) : Serializable