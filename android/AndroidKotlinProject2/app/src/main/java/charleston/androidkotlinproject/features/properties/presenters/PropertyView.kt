package charleston.androidkotlinproject.features.properties.presenters

import charleston.androidkotlinproject.data.domain.Property

/**
 * Created by charleston.anjos on 03/10/17.
 */
interface PropertyView {
    fun showList(properties: List<Property>)
    fun showDetail(property: Property)
    fun showError(message: String)
    fun showLoading(show: Boolean, hasError: Boolean)
}