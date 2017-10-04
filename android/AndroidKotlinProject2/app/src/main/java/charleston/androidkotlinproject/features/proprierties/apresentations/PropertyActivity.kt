package charleston.androidkotlinproject.features.proprierties.apresentations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.domain.Property
import charleston.androidkotlinproject.features.proprierties.apresentations.adapters.PropertyAdapter
import charleston.androidkotlinproject.features.proprierties.presenters.PropriertiePresenter
import charleston.androidkotlinproject.features.proprierties.presenters.PropriertieView

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropertyActivity : AppCompatActivity(), PropriertieView {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.main_list) }

    private val presenter: PropriertiePresenter by lazy { PropriertiePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.findAll()
    }

    override fun showList(list: List<Property>) {
        recyclerView.adapter = PropertyAdapter(this, list)
    }
}