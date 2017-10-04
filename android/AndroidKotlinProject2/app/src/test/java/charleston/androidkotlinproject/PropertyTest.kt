package charleston.androidkotlinproject

import charleston.androidkotlinproject.data.domain.PropertyDetailResponse
import charleston.androidkotlinproject.data.domain.PropertyResponse
import charleston.androidkotlinproject.data.remote.features.property.PropertyManager
import charleston.androidkotlinproject.di.DaggerTestComponent
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named
import kotlin.test.assertTrue

/**
 * Created by charleston.anjos on 04/10/17.
 */
class PropertyTest {

    @Inject
    @Named("test")
    lateinit var manager: PropertyManager

    @Before
    fun setup() {
        DaggerTestComponent.builder().build().inject(this)
    }

    @Test
    fun testList() {
        val testSubscriber = TestObserver<PropertyResponse>()

        manager.findAll().subscribe(testSubscriber)

        testSubscriber.assertNoErrors()
        testSubscriber.assertNoTimeout()
        testSubscriber.assertSubscribed()

        testSubscriber.assertOf {
            val response = it.values()[0]
            assertTrue { response.properties.isNotEmpty() }
        }
    }

    @Test
    fun testDetail() {
        val testSubscriber = TestObserver<PropertyDetailResponse>()

        manager.findById(1).subscribe(testSubscriber)

        testSubscriber.assertNoErrors()
        testSubscriber.assertNoTimeout()
        testSubscriber.assertSubscribed()

        testSubscriber.assertOf {
            val response = it.values()[0]
            assertTrue { response.property != null }
        }
    }
}