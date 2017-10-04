package charleston.androidkotlinproject

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
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
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingAndroidInjectorService: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun serviceInjector(): DispatchingAndroidInjector<Service>? {
        return dispatchingAndroidInjectorService
    }
}