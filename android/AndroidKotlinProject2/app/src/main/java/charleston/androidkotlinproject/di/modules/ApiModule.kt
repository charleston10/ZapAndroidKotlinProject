package charleston.androidkotlinproject.di.modules

import charleston.androidkotlinproject.data.remote.configurations.DateAdapter
import charleston.androidkotlinproject.data.remote.features.property.PropertyManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by charleston.anjos on 03/10/17.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGsonFactory(): Gson {
        return GsonBuilder().registerTypeAdapter(Date::class.java, DateAdapter()).setLenient().create()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonFactory: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://demo4573903.mockable.io/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonFactory))
                .client(httpClient)
                .build()
    }

    @Provides
    @Singleton
    fun providePropertyManager(retrofit: Retrofit): PropertyManager {
        return PropertyManager(retrofit)
    }

    @Provides
    @Singleton
    @Named("test")
    fun provideRetrofitTest(gsonFactory: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonFactory))
                .client(httpClient)
                .build()
    }

    @Provides
    @Singleton
    @Named("test")
    fun providePropertyManagerTest(@Named("test") retrofit: Retrofit): PropertyManager {
        return PropertyManager(retrofit)
    }
}