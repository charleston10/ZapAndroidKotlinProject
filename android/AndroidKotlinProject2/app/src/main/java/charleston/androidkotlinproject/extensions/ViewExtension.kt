package charleston.androidkotlinproject.extensions

import android.view.View

/**
 * Created by charleston.anjos on 03/10/17.
 */
fun View.show() {
    this.alpha = 0.0f
    this.visibility = View.VISIBLE
    this.animate().setDuration(700).alpha(1.00f).start()
}