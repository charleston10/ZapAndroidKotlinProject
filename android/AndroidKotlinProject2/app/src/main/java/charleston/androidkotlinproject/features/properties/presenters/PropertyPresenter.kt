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
        manager.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe({
                    view.showList(it.properties)
                }, {
                    view.showMessage(context.getString(R.string.message_error))
                })
    }

    fun findById(id: Long) {
        manager.findById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe({
                    view.showDetail(it.property)
                }, {
                    view.showMessage(context.getString(R.string.message_error))
                })
    }
}