package charleston.androidkotlinproject.features.properties.presentations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.*
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.domain.Property
import charleston.androidkotlinproject.data.domain.PropertyDetail
import charleston.androidkotlinproject.extensions.*
import charleston.androidkotlinproject.features.properties.presenters.PropertyPresenter
import charleston.androidkotlinproject.features.properties.presenters.PropertyView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.widget.ArrayAdapter


/**
 * Created by charleston.anjos on 04/10/17.
 */
class PropertyDetailActivity : AppCompatActivity(), PropertyView {

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    private val imgCover: ImageView by lazy { findViewById<ImageView>(R.id.property_detail_cover) }
    private val tvAddressCity: TextView by lazy { findViewById<TextView>(R.id.property_detail_address_city) }
    private val tvAddressNeighborood: TextView by lazy { findViewById<TextView>(R.id.property_detail_address_neighborhood) }
    private val tvAddressZone: TextView by lazy { findViewById<TextView>(R.id.property_detail_address_zone) }
    private val tvPrice: TextView by lazy { findViewById<TextView>(R.id.property_detail_price) }
    private val tvPriceCondominium: TextView by lazy { findViewById<TextView>(R.id.property_detail_condominium) }
    private val tvBedroom: TextView by lazy { findViewById<TextView>(R.id.property_detail_bedroom) }
    private val tvSuits: TextView by lazy { findViewById<TextView>(R.id.property_detail_suits) }
    private val tvSpaceAvailable: TextView by lazy { findViewById<TextView>(R.id.property_detail_space_available) }
    private val tvClient: TextView by lazy { findViewById<TextView>(R.id.property_detail_client) }
    private val tvType: TextView by lazy { findViewById<TextView>(R.id.property_detail_type) }
    private val tvDescription: TextView by lazy { findViewById<TextView>(R.id.property_detail_description) }
    private val listCharacteristics: ListView by lazy { findViewById<ListView>(R.id.property_detail_list_characteristics) }
    private val listCharacteristicsFeatures: ListView by lazy { findViewById<ListView>(R.id.property_detail_list_characteristics_features) }

    private val contentView: LinearLayout by lazy { findViewById<LinearLayout>(R.id.content) }
    private val loadingView: LottieAnimationView by lazy { findViewById<LottieAnimationView>(R.id.loading) }

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

    override fun showDetail(property: PropertyDetail) {
        Glide.with(this)
                .load(property.imageUrl)
                .apply(RequestOptions().placeholder(R.drawable.no_image).error(R.drawable.no_image))
                .into(imgCover)

        tvType.text = property.type

        tvDescription.text = property.description

        tvAddressCity.text = String.format(getString(R.string.label_address_city), property.address.city)
        tvAddressNeighborood.text = String.format(getString(R.string.label_address_neighborhood), property.address.neighborhood)
        tvAddressZone.text = property.address.zone

        tvPrice.text = String.format(getString(R.string.label_price), property.price.moneyFormat)
        tvPriceCondominium.text = String.format(getString(R.string.label_price_condominium), property.priceCondominium.moneyFormat)
        tvBedroom.text = plurals(property.bedroom, R.string.label_bedroom_zero, R.plurals.label_bedroom)
        tvSuits.text = plurals(property.suit, R.string.label_suit_zero, R.plurals.label_suit)
        tvSpaceAvailable.text = plurals(property.spaceAvailable, R.string.label_space_available_zero, R.plurals.label_space_available)
        tvClient.text = property.client.name

        listCharacteristics.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, property.characteristics)
        listCharacteristicsFeatures.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, property.characteristicsFeatures)
    }

    override fun showList(properties: List<Property>) {
        //not implemented
    }

    override fun showError(message: String) {
        contentView.hide()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(show: Boolean, hasError: Boolean) {
        when {
            show -> {
                contentView.hide()
                loadingView.show()
            }
            hasError -> {
                loadingView.hide()
                contentView.hide()
            }
            else -> {
                loadingView.hide()
                contentView.show()
            }
        }
    }

}