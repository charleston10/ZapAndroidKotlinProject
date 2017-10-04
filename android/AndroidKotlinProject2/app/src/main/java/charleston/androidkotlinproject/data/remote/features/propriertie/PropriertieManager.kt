package charleston.androidkotlinproject.data.remote.features.propriertie

import charleston.androidkotlinproject.data.domain.PropertieResponse
import charleston.androidkotlinproject.data.domain.Property
import io.reactivex.Observable
import retrofit2.Retrofit

/**
 * Created by charleston.anjos on 03/10/17.
 */

class PropriertieManager(val retrofit: Retrofit) {

    fun findAll(): Observable<PropertieResponse> {
        return retrofit.create(PropriertieWorker::class.java).findAll()
    }

    fun findById(id: Long): Observable<Property> {
        return retrofit.create(PropriertieWorker::class.java).findAById(id)
    }
}