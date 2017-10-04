package charleston.androidkotlinproject.features.properties.presentations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.domain.Property
import charleston.androidkotlinproject.features.properties.presentations.adapters.PropertyAdapter
import charleston.androidkotlinproject.features.properties.presenters.PropertyPresenter
import charleston.androidkotlinproject.features.properties.presenters.PropertyView

/**
 * Created by charleston.anjos on 03/10/17.
 */
class PropertyActivity : AppCompatActivity(), PropertyView, PropertyAdapter.PropertyListener {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.main_list) }

    private val presenter: PropertyPresenter by lazy { PropertyPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.findAll()
    }

    override fun showList(properties: List<Property>) {
        recyclerView.adapter = PropertyAdapter(this, properties, this)
    }

    override fun showDetail(property: Property) {
        //not implemented
    }

    override fun onClick(property: Property) {
        startActivity(PropertyDetailActivity.getIntent(this, property.id))
    }
}