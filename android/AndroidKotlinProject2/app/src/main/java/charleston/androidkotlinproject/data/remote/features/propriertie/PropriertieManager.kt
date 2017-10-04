package charleston.androidkotlinproject.data.remote.features.propriertie

import charleston.androidkotlinproject.data.domain.PropertieResponse
import charleston.androidkotlinproject.data.domain.Propriertie
import dagger.Reusable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by charleston.anjos on 03/10/17.
 */

class PropriertieManager(val retrofit: Retrofit) {

    fun findAll(): Observable<PropertieResponse> {
        return retrofit.create(PropriertieWorker::class.java).findAll()
    }

    fun findById(id: Long): Observable<Propriertie> {
        return retrofit.create(PropriertieWorker::class.java).findAById(id)
    }
}