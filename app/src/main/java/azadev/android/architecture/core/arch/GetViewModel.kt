package azadev.android.architecture.core.arch

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import kotlin.reflect.KProperty

class GetViewModel<out T : ViewModel>(private val clazz: Class<T>) {

	private var value: T? = null

	operator fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T {
		if (value == null) {
			value = ViewModelProviders.of(thisRef).get(clazz)
		}

		return value!!
	}

	operator fun getValue(thisRef: Fragment, property: KProperty<*>): T {
		if (value == null) {
			value = ViewModelProviders.of(thisRef).get(clazz)
		}

		return value!!
	}
}

inline fun <reified T : ViewModel> viewModel() = GetViewModel(T::class.java)
