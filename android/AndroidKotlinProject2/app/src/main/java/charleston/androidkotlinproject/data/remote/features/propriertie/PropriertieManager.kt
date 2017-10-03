package charleston.androidkotlinproject.data.remote.features.propriertie

import charleston.androidkotlinproject.data.domain.Propriertie
import charleston.androidkotlinproject.data.remote.base.BaseManager
import io.reactivex.Observable

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropriertieManager : BaseManager<PropriertieWorker> {

    constructor(test: Boolean = false) : super(PropriertieWorker::class.java, test)

    fun findAll(): Observable<List<Propriertie>> {
        return service().findAll()
    }

    fun findById(id: Int): Observable<Propriertie> {
        return service().findAById(id)
    }
}