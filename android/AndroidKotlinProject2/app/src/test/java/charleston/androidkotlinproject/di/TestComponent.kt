package charleston.androidkotlinproject.di

import charleston.androidkotlinproject.PropertyTest
import charleston.androidkotlinproject.di.modules.ApiModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by charleston.anjos on 04/10/17.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ApiModule::class))
interface TestComponent  {
    fun inject(propertyTest: PropertyTest)
}