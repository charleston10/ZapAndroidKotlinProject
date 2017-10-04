package charleston.androidkotlinproject.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

/**
 * Created by charleston.anjos on 03/10/17.
 */
fun View.show() {
    val view = this

    view.alpha = 0.0f
    view.animate()
            .setDuration(700)
            .alpha(1.00f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    view.visibility = View.VISIBLE
                }
            })
            .setStartDelay(700)
            .start()
}

fun View.hide() {
    val view = this

    view.alpha = 1.0f
    view.animate()
            .setDuration(700)
            .alpha(0.00f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    view.visibility = View.GONE
                }
            })
            .setStartDelay(800)
            .start()
}