package azadev.archtest.core.databinding.adapters

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("app:visibile")
fun setVisibile(view: View, value: Boolean) {
	if (value) {
		view.visibility = View.VISIBLE
	}
	else {
		view.visibility = View.GONE
	}
}
