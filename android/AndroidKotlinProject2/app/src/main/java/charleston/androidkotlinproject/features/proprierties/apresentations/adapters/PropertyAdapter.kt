package charleston.androidkotlinproject.features.proprierties.apresentations.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import charleston.androidkotlinproject.R
import charleston.androidkotlinproject.data.domain.Property
import charleston.androidkotlinproject.extensions.moneyFormat
import com.bumptech.glide.Glide

/**
 * Created by charleston.anjos on 04/10/17.
 */
class PropertyAdapter(private val context: Context, private val list: List<Any>) : RecyclerView.Adapter<PropertyAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder? {
        val view = LayoutInflater.from(context).inflate(R.layout.item_property, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
        val property = list[position] as Property
        val viewHolder = holder as ListViewHolder

        viewHolder.tvType.text = property.type
        viewHolder.tvAddress.text = property.address.neighborhood
        viewHolder.tvPrice.text = property.price.moneyFormat

        Glide.with(context)
                .load(property.imageUrl)
                .into(viewHolder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvType: TextView = itemView.findViewById(R.id.item_property_type)
        val tvAddress: TextView = itemView.findViewById(R.id.item_property_address_neighborhood)
        val tvPrice: TextView = itemView.findViewById(R.id.item_property_price)
        val image: ImageView = itemView.findViewById(R.id.item_property_image)
    }
}