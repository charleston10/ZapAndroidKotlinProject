package charleston.androidkotlinproject.data.remote.features.property

import charleston.androidkotlinproject.data.domain.PropertyResponse
import charleston.androidkotlinproject.data.domain.Property
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by charleston.anjos on 03/10/17.
 */
interface PropertyWorker {

    @GET(PropertyEndPoint.FIND_ALL)
    fun findAll(): Observable<PropertyResponse>

    @GET(PropertyEndPoint.FIND_BY_ID)
    fun findAById(@Path("id") id: Long): Observable<Property>
}