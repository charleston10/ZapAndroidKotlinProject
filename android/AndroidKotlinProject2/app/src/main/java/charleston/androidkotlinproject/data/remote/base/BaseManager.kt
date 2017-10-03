package charleston.androidkotlinproject.data.remote.base

import okhttp3.HttpUrl
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by charleston.anjos on 03/10/17.
 */
open class BaseManager<T>(serviceClass: Class<T>, val test: Boolean = false) {

    @Inject
    lateinit var retrofit: Retrofit

    var clazz: Class<T> = serviceClass

    init {
        if (test) {
            retrofit.newBuilder().baseUrl(HttpUrl.parse("")).build()
        }
    }

    fun service(): T {
        return retrofit.create(clazz)
    }
}