package charleston.androidkotlinproject.features.proprierties.apresentations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.domain.Property
import charleston.androidkotlinproject.features.proprierties.apresentations.adapters.PropertyAdapter
import charleston.androidkotlinproject.features.proprierties.presenters.PropertyPresenter
import charleston.androidkotlinproject.features.proprierties.presenters.PropertyView

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropertyActivity : AppCompatActivity(), PropertyView {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.main_list) }

    private val presenter: PropertyPresenter by lazy { PropertyPresenter(this) }

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