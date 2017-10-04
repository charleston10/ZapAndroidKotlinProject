package charleston.androidkotlinproject.features.proprierties.presenters

import charleston.androidkotlinproject.data.domain.Property

/**
 * Created by charleston.anjos on 03/10/17.
 */
interface PropertyView {
    fun showList(list: List<Property>)
}