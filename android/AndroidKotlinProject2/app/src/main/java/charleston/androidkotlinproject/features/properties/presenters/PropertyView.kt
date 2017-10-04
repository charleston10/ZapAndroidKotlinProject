package charleston.androidkotlinproject.features.properties.presenters

import charleston.androidkotlinproject.data.domain.Property
import charleston.androidkotlinproject.data.domain.PropertyDetail

/**
 * Created by charleston.anjos on 03/10/17.
 */
interface PropertyView {
    fun showList(properties: List<Property>)
    fun showDetail(property: PropertyDetail)
    fun showError(message: String)
    fun showLoading(show: Boolean, hasError: Boolean)
}