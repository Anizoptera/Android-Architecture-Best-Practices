package azadev.android.architecture.core.databinding.adapters

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("app:invisible")
fun setInvisible(view: View, value: Boolean) {
	if (value) {
		view.visibility = View.INVISIBLE
	}
	else {
		view.visibility = View.VISIBLE
	}
}
