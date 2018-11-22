package azadev.android.architecture.core.databinding.adapters

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("app:visible")
fun setVisible(view: View, value: Boolean) {
	view.visibility = if (value) View.VISIBLE else View.GONE
}
