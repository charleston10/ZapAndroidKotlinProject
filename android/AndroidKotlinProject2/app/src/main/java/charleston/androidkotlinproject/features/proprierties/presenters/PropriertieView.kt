package charleston.androidkotlinproject.features.proprierties.presenters

import charleston.androidkotlinproject.data.domain.Propriertie

/**
 * Created by charleston.anjos on 03/10/17.
 */
interface PropriertieView {
    fun showList(list: List<Propriertie>)
}