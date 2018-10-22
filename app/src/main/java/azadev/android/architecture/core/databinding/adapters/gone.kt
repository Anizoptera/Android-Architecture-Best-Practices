package azadev.android.architecture.core.databinding.adapters

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("app:gone")
fun setGone(view: View, value: Boolean) {
	if (value) {
		view.visibility = View.GONE
	}
	else {
		view.visibility = View.VISIBLE
	}
}
