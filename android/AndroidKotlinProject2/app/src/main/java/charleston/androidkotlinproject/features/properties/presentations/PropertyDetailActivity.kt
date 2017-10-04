package charleston.androidkotlinproject.features.properties.presentations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.domain.Property
import charleston.androidkotlinproject.extensions.create
import charleston.androidkotlinproject.extensions.moneyFormat
import charleston.androidkotlinproject.features.properties.presenters.PropertyPresenter
import charleston.androidkotlinproject.features.properties.presenters.PropertyView

/**
 * Created by charleston.anjos on 04/10/17.
 */
class PropertyDetailActivity : AppCompatActivity(), PropertyView {

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    private val presenter: PropertyPresenter by lazy { PropertyPresenter(this) }

    companion object {
        private val EXTRA_ID = "EXTRA_ID"

        fun getIntent(context: Context, id: Long): Intent {
            return Intent(context, PropertyDetailActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        toolbar.create(this, getString(R.string.title_detail), true)

        val id = intent.extras.getLong(EXTRA_ID)
        if (id > 0) {
            presenter.findById(id)
        }
    }

    override fun showDetail(detail: Property) {
        Toast.makeText(this, "Find by Id " + detail.price.moneyFormat, Toast.LENGTH_SHORT).show()
    }

    override fun showList(list: List<Property>) {
        //not implemented
    }
}