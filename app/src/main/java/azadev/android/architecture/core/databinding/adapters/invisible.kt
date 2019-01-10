package azadev.android.architecture.core.databinding.adapters

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("app:invisible")
fun setInvisible(view: View, value: Boolean) {
	view.visibility = if (value) View.INVISIBLE else View.VISIBLE
}
