package charleston.androidkotlinproject.extensions

import android.content.Context

/**
 * Created by charleston.anjos on 04/10/17.
 */
fun Context.plurals(quantity: Int, zero: Int, plurals: Int): String {
    return if (quantity == 0) {
        getString(zero)
    } else {
        resources.getQuantityString(plurals, quantity, quantity)
    }
}