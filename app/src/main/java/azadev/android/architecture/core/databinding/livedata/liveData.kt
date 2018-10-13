package azadev.android.architecture.core.databinding.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData

fun <T> mutableLiveData(defaultValue: T? = null): MutableLiveData<T> {
	val data = MutableLiveData<T>()

	if (defaultValue != null) {
		data.value = defaultValue
	}

	return data
}

fun <T> mediatorLiveData(vararg liveDataItems: LiveData<*>, predicate: () -> T): MediatorLiveData<T> {
	val mediator = MediatorLiveData<T>()

	liveDataItems.forEach { data ->
		mediator.addSource(data) {
			mediator.value = predicate()
		}
	}

	return mediator
}
