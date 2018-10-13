package azadev.archtest.core.databinding.livedata

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import kotlin.reflect.KProperty

class SetContentView<out T : ViewDataBinding>(@LayoutRes private val layoutRes: Int) {

	private var value: T? = null

	operator fun getValue(thisRef: Activity, property: KProperty<*>): T {
		if (value == null) {
			value = DataBindingUtil.setContentView(thisRef, layoutRes)
		}

		return value!!
	}
}

fun <T : ViewDataBinding> contentView(@LayoutRes layoutRes: Int) = SetContentView<T>(layoutRes)
