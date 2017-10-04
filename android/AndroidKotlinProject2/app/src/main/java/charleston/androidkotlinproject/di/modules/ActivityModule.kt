package charleston.androidkotlinproject.di.modules

import charleston.androidkotlinproject.features.properties.presentations.PropertyActivity
import charleston.androidkotlinproject.features.properties.presentations.PropertyDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by charleston.anjos on 03/10/17.
 */
@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun propertyActivity(): PropertyActivity

    @ContributesAndroidInjector(modules = arrayOf())
    internal abstract fun propertyDetailActivity(): PropertyDetailActivity

}