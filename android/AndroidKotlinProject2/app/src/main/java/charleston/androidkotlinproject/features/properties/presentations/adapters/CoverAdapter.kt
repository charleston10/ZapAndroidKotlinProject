package charleston.androidkotlinproject.features.properties.presentations.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import charleston.androidkotlinproject.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by charleston.anjos on 04/10/17.
 */
class CoverAdapter(private val context: Context, private val list: List<Any>) : RecyclerView.Adapter<CoverAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder? {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cover, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
        val url = list[position] as String
        val viewHolder = holder as ListViewHolder

        Glide.with(context)
                .load(url)
                .apply(
                        RequestOptions()
                                .centerCrop()
                                .placeholder(R.drawable.no_image)
                                .error(R.drawable.no_image)

                )
                .into(viewHolder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cover)
    }
}