package charleston.androidkotlinproject.data.remote.features.propriertie

import charleston.androidkotlinproject.data.domain.Propriertie
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropriertieManager {

    @Inject
    lateinit var retrofit: Retrofit

    fun findAll(): Observable<List<Propriertie>> {
        return retrofit.create(PropriertieWorker::class.java).findAll()
    }

    fun findById(id: Int): Observable<Propriertie> {
        return retrofit.create(PropriertieWorker::class.java).findAById(id)
    }
}