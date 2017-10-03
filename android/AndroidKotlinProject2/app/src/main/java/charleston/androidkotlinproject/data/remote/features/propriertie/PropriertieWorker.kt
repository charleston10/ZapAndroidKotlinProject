package charleston.androidkotlinproject.data.remote.features.propriertie

import charleston.androidkotlinproject.data.domain.Propriertie
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by charleston.anjos on 03/10/17.
 */
interface PropriertieWorker {

    @GET(PropriertieEndPoint.FIND_ALL)
    fun findAll(): Observable<List<Propriertie>>

    @GET(PropriertieEndPoint.FIND_BY_ID)
    fun findAById(@Path("id") id: Int): Observable<Propriertie>
}