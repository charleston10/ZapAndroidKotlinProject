package charleston.androidkotlinproject.data.remote

import charleston.androidkotlinproject.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by charleston.anjos on 03/10/17.
 */
class ZapApi {

    private val gsonFactory: Gson = GsonBuilder().setLenient().create()

    private val httpClient = OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)

    private val builder = Retrofit.Builder()
            .baseUrl("")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonFactory))

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level =
                if (!BuildConfig.DEBUG) HttpLoggingInterceptor.Level.NONE else HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(loggingInterceptor)
    }

    fun <T> createService(serviceClass: Class<T>): T {
        httpClient.addInterceptor { chain ->
            val original = chain!!.request()

            val requestBuilder = original.newBuilder()

            requestBuilder.removeHeader("Accept")
            requestBuilder.addHeader("Accept", "application/json")

            val request = requestBuilder.build()

            chain.proceed(request)
        }

        val retrofit = builder.client(httpClient.build()).build()
        return retrofit.create(serviceClass)
    }
}