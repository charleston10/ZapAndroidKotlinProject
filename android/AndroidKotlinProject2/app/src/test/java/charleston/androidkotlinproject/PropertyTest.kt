package charleston.androidkotlinproject

import charleston.androidkotlinproject.data.domain.PropertyResponse
import charleston.androidkotlinproject.data.remote.features.property.PropertyManager
import charleston.androidkotlinproject.di.DaggerTestComponent
import io.reactivex.observers.TestObserver
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named
import kotlin.test.assertTrue

/**
 * Created by charleston.anjos on 04/10/17.
 */
class PropertyTest {

    private var server = MockWebServer()

    @Inject
    @Named("test")
    lateinit var manager: PropertyManager

    @Before
    fun setup() {
        DaggerTestComponent.builder().build().inject(this)
        server.start()
    }

    @Test
    fun testList() {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)
        mockResponse.setBody(list())

        server.enqueue(mockResponse)

        val testSubscriber = TestObserver<PropertyResponse>()

        manager.findAll().subscribe(testSubscriber)

        testSubscriber.assertNoErrors()
        testSubscriber.assertNoTimeout()
        testSubscriber.assertSubscribed()

        testSubscriber.assertOf {
            val response = it.values()[0]
            assertTrue { response.properties.isNotEmpty() }
        }
    }

    fun list(): String {
        return "{\n" +
                "  \"Imoveis\": [\n" +
                "    {\n" +
                "      \"CodImovel\": 1,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Numero\": \"100\",\n" +
                "        \"CEP\": \"03591010\",\n" +
                "        \"Bairro\": \"BARRA FUNDA\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Zona Oeste\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 195000,\n" +
                "      \"Dormitorios\": 1,\n" +
                "      \"Suites\": 0,\n" +
                "      \"Vagas\": 0,\n" +
                "      \"AreaUtil\": 31,\n" +
                "      \"AreaTotal\": 31,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2294995,\n" +
                "        \"NomeFantasia\": \"Roselene Cardoso\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/imoveis/2294995/vivabarra/1c8fee3d141044e594d9_grande.jpg\",\n" +
                "      \"SubTipoOferta\": \"Destaque\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 8764402,\n" +
                "      \"TipoImovel\": \"Comercial/Industrial\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"RUA QUINZE DE NOVEMBRO\",\n" +
                "        \"Numero\": \"184\",\n" +
                "        \"Complemento\": \"Conjunto 1.101\",\n" +
                "        \"CEP\": \"01013904\",\n" +
                "        \"Bairro\": \"CENTRO\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Centro\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 525000,\n" +
                "      \"Dormitorios\": 4,\n" +
                "      \"Suites\": 0,\n" +
                "      \"Vagas\": 0,\n" +
                "      \"AreaUtil\": 131,\n" +
                "      \"AreaTotal\": 166,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 1785817,\n" +
                "        \"NomeFantasia\": \"Marcelo\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/imoveis/1785817/zap692308/3c3d8b980f2c4b40a403_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Destaque\",\n" +
                "      \"SubtipoImovel\": \"Conjunto Comercial/Sala\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 10565168,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"AVENIDA ESTADO, DO\",\n" +
                "        \"Numero\": \"5748\",\n" +
                "        \"Complemento\": \"\",\n" +
                "        \"CEP\": \"01516100\",\n" +
                "        \"Bairro\": \"CENTRO\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Centro\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 210000,\n" +
                "      \"Dormitorios\": 1,\n" +
                "      \"Suites\": 0,\n" +
                "      \"Vagas\": 0,\n" +
                "      \"AreaUtil\": 33,\n" +
                "      \"AreaTotal\": 33,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2226241,\n" +
                "        \"NomeFantasia\": \"Lopes Castan\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/2226241/7c67cadc-2b45-4252-ac37-451df5d4972f_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Normal\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 11062221,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"RUA ANTONIO MACHADO\",\n" +
                "        \"Numero\": \"266\",\n" +
                "        \"Complemento\": \"Várias Unidades\",\n" +
                "        \"CEP\": \"03677230\",\n" +
                "        \"Bairro\": \"S MIGUEL PTA\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Zona Leste\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 309000,\n" +
                "      \"Dormitorios\": 2,\n" +
                "      \"Suites\": 1,\n" +
                "      \"Vagas\": 1,\n" +
                "      \"AreaUtil\": 54,\n" +
                "      \"AreaTotal\": 54,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2506850,\n" +
                "        \"NomeFantasia\": \"ZEN CASA IMOVEIS\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/2506850/d8a76b8b-bc9b-49b8-8306-0482b9a2022f_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Normal\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 10711073,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"RUA RENATO EGYDIO DE SOUSA ARANHA\",\n" +
                "        \"Numero\": \"221\",\n" +
                "        \"Complemento\": \"\",\n" +
                "        \"CEP\": \"05353050\",\n" +
                "        \"Bairro\": \"VL S FRANCISCO\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Zona Sul\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 650000,\n" +
                "      \"Dormitorios\": 2,\n" +
                "      \"Suites\": 1,\n" +
                "      \"Vagas\": 2,\n" +
                "      \"AreaUtil\": 104,\n" +
                "      \"AreaTotal\": 104,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 1316130,\n" +
                "        \"NomeFantasia\": \"Krisos Imobiliaria\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/1316130/359c99b1-f722-4808-a450-a1f32a6a63da_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Destaque\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 10555364,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"AVENIDA LUIS STAMATIS\",\n" +
                "        \"Numero\": \"1031\",\n" +
                "        \"Complemento\": \"\",\n" +
                "        \"CEP\": \"02260001\",\n" +
                "        \"Bairro\": \"VL CONSTÂNCIA\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Zona Sul\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 300000,\n" +
                "      \"Dormitorios\": 2,\n" +
                "      \"Suites\": 1,\n" +
                "      \"Vagas\": 1,\n" +
                "      \"AreaUtil\": 53,\n" +
                "      \"AreaTotal\": 53,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2066920,\n" +
                "        \"NomeFantasia\": \"LOPES CONDESSA\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/2066920/d0703057-b887-4228-a134-4cfc44d747ce_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Destaque\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 9389359,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"RUA CONDE DE SAO JOAQUIM\",\n" +
                "        \"Numero\": \"340\",\n" +
                "        \"Complemento\": \"\",\n" +
                "        \"CEP\": \"01320010\",\n" +
                "        \"Bairro\": \"BELA VISTA\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Centro\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 314000,\n" +
                "      \"Dormitorios\": 1,\n" +
                "      \"Suites\": 0,\n" +
                "      \"Vagas\": 1,\n" +
                "      \"AreaUtil\": 30,\n" +
                "      \"AreaTotal\": 57,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2668502,\n" +
                "        \"NomeFantasia\": \"Guilherme\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/imoveis/2668502/zap734176/ce60ecf62b8b4a269653_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Destaque\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 9924045,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"RUA FRANKLIN MAGALHAES\",\n" +
                "        \"Numero\": \"Sob Consulta\",\n" +
                "        \"Complemento\": \"\",\n" +
                "        \"CEP\": \"04374000\",\n" +
                "        \"Bairro\": \"VL STA CATARINA\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Zona Sul\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 372000,\n" +
                "      \"Dormitorios\": 2,\n" +
                "      \"Suites\": 0,\n" +
                "      \"Vagas\": 2,\n" +
                "      \"AreaUtil\": 64,\n" +
                "      \"AreaTotal\": 64,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2300761,\n" +
                "        \"NomeFantasia\": \"SkyRealty\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/2300761/942886d6-3e96-437b-ae32-d8bcf2e800fd_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Normal\",\n" +
                "      \"DistanciaKilometros\": 5669.71117077715,\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 9343813,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"AVENIDA NOSSA SENHORA DO SABARA\",\n" +
                "        \"Numero\": \"Sob Consulta\",\n" +
                "        \"Complemento\": \"\",\n" +
                "        \"CEP\": \"04447021\",\n" +
                "        \"Bairro\": \"JD SABARÁ\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Zona Sul\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 276000,\n" +
                "      \"Dormitorios\": 2,\n" +
                "      \"Suites\": 0,\n" +
                "      \"Vagas\": 1,\n" +
                "      \"AreaUtil\": 48,\n" +
                "      \"AreaTotal\": 48,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2300761,\n" +
                "        \"NomeFantasia\": \"SkyRealty\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/2300761/31b3ac1e-1b86-4e24-a5b7-33b1236c794c_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Normal\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"CodImovel\": 10854915,\n" +
                "      \"TipoImovel\": \"Apartamento\",\n" +
                "      \"Endereco\": {\n" +
                "        \"Logradouro\": \"RUA JOSE BENEDITO SALINAS\",\n" +
                "        \"Numero\": \"Sob Consulta\",\n" +
                "        \"Complemento\": \"\",\n" +
                "        \"CEP\": \"04674200\",\n" +
                "        \"Bairro\": \"JD MARAJOARA\",\n" +
                "        \"Cidade\": \"SAO PAULO\",\n" +
                "        \"Estado\": \"SP\",\n" +
                "        \"Zona\": \"Zona Sul\"\n" +
                "      },\n" +
                "      \"PrecoVenda\": 435000,\n" +
                "      \"Dormitorios\": 2,\n" +
                "      \"Suites\": 0,\n" +
                "      \"Vagas\": 1,\n" +
                "      \"AreaUtil\": 67,\n" +
                "      \"AreaTotal\": 67,\n" +
                "      \"DataAtualizacao\": \"/Date(-62135596800000-0000)/\",\n" +
                "      \"Cliente\": {\n" +
                "        \"CodCliente\": 2300761,\n" +
                "        \"NomeFantasia\": \"SkyRealty\"\n" +
                "      },\n" +
                "      \"UrlImagem\": \"http://imagens.zapcorp.com.br/2300761/fafd0727-d00d-436e-ad29-2dc3261ef7df_grande.jpg\",\n" +
                "      \"StatusQualidadeTotal\": false,\n" +
                "      \"EstagioObra\": \"NaoInformado\",\n" +
                "      \"SubTipoOferta\": \"Destaque\",\n" +
                "      \"SubtipoImovel\": \"Apartamento Padrão\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"
    }
}