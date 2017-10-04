package charleston.androidkotlinproject.di.components

import android.app.Application
import charleston.androidkotlinproject.App
import charleston.androidkotlinproject.di.modules.ActivityModule
import charleston.androidkotlinproject.di.modules.ApiModule
import charleston.androidkotlinproject.di.modules.AppModule
import charleston.androidkotlinproject.features.proprierties.presenters.PropertyPresenter
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import junit.framework.Test
import javax.inject.Singleton

/**
 * Created by charleston.anjos on 03/10/17.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityModule::class, ApiModule::class))
interface AppComponent {

    fun inject(application: App)
    fun inject(propertyPresenter: PropertyPresenter)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}