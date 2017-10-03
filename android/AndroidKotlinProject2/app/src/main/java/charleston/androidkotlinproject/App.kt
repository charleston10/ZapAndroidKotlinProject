package charleston.androidkotlinproject

import android.app.Activity
import android.app.Application
import android.app.Service
import charleston.androidkotlinproject.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

/**
 * Created by charleston.anjos on 03/10/17.
 */
class App : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    @Inject
    internal var dispatchingAndroidInjectorService: DispatchingAndroidInjector<Service>? = null

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun serviceInjector(): DispatchingAndroidInjector<Service>? {
        return dispatchingAndroidInjectorService
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}