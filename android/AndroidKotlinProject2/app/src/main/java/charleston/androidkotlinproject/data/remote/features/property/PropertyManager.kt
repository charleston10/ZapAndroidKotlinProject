package charleston.androidkotlinproject.data.remote.features.property

import charleston.androidkotlinproject.data.domain.PropertyResponse
import charleston.androidkotlinproject.data.domain.Property
import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by charleston.anjos on 03/10/17.
 */

class PropertyManager(val retrofit: Retrofit) {

    fun findAll(): Observable<PropertyResponse> {
        return retrofit.create(PropertyWorker::class.java).findAll()
    }

    fun findById(id: Long): Observable<Property> {
        return retrofit.create(PropertyWorker::class.java).findAById(id)
    }
}