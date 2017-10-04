package charleston.androidkotlinproject.features.proprierties.apresentations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.domain.Propriertie
import charleston.androidkotlinproject.features.proprierties.presenters.PropriertiePresenter
import charleston.androidkotlinproject.features.proprierties.presenters.PropriertieView
import timber.log.Timber

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropriertActivity : AppCompatActivity(), PropriertieView {

    private val presenter: PropriertiePresenter by lazy { PropriertiePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.findAll()
    }

    override fun showList(list: List<Propriertie>) {
        Timber.i("listou")
    }
}