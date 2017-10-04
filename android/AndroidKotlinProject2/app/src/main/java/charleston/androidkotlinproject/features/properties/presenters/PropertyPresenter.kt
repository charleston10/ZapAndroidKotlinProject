package charleston.androidkotlinproject.features.properties.presenters

import android.content.Context
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.remote.features.property.PropertyManager
import charleston.androidkotlinproject.di.AppInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropertyPresenter(private val view: PropertyView) {

    @Inject
    lateinit var manager: PropertyManager

    @Inject
    lateinit var context: Context

    init {
        AppInjector.dagger.inject(this)
    }

    fun findAll() {
        view.showLoading(true, false)
        manager.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe({
                    view.showLoading(false, false)
                    view.showList(it.properties)
                }, {
                    view.showLoading(false, true)
                    it.printStackTrace()
                    view.showError(context.getString(R.string.message_error))
                })
    }

    fun findById(id: Long) {
        view.showLoading(true, false)

        manager.findById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe({
                    view.showLoading(false, false)
                    view.showDetail(it.property)
                }, {
                    it.printStackTrace()
                    view.showError(context.getString(R.string.message_error))
                    view.showLoading(false, true)
                })
    }
}