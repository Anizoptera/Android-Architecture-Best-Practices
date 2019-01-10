package azadev.android.architecture.core.databinding.adapters

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("app:gone")
fun setGone(view: View, value: Boolean) {
	view.visibility = if (value) View.GONE else View.VISIBLE
}
