package azadev.android.architecture.core.databinding.inflaters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentActivity
import kotlin.reflect.KProperty

class SetContentView<out T : ViewDataBinding>(@LayoutRes private val layoutRes: Int) {

	private var value: T? = null

	operator fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T {
		if (value == null) {
			value = DataBindingUtil.setContentView(thisRef, layoutRes)
			value!!.setLifecycleOwner(thisRef)
		}

		return value!!
	}
}

fun <T : ViewDataBinding> contentView(@LayoutRes layoutRes: Int) = SetContentView<T>(layoutRes)
