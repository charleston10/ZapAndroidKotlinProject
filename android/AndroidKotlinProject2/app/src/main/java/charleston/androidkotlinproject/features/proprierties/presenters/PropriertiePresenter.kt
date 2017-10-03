package charleston.androidkotlinproject.features.proprierties.presenters

import charleston.androidkotlinproject.data.remote.features.propriertie.PropriertieManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropriertiePresenter(val view: PropriertieView) {

    @Inject
    lateinit var manager: PropriertieManager

    fun findAll() {
        manager.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe({
                    view.showList(it)
                })
    }
}