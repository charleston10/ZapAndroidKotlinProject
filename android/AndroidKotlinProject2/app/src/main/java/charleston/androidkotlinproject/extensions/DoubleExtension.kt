package charleston.androidkotlinproject.extensions

import java.text.NumberFormat
import java.util.*

/**
 * Created by charleston.anjos on 04/10/17.
 */
val Double.moneyFormat: String
    get() {
        val numberFormat = NumberFormat.getNumberInstance(Locale("pt", "BR"))
        numberFormat.minimumFractionDigits = 2
        numberFormat.maximumFractionDigits = 2

        return "R$ " + numberFormat.format(this)
    }