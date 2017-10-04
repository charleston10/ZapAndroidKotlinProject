package charleston.androidkotlinproject.features.proprierties.presenters

import charleston.androidkotlinproject.data.remote.features.propriertie.PropriertieManager
import charleston.androidkotlinproject.di.AppInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropriertiePresenter(private val view: PropriertieView) {

    @Inject
    lateinit var manager: PropriertieManager

    init {
        AppInjector.dagger.inject(this)
    }

    fun findAll() {
        manager.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe {
                    view.showList(it.properties)
                }
    }

    fun findById(id: Long) {
        manager.findById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe {

                }
    }

}