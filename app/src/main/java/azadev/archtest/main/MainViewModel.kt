package azadev.archtest.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
	var value1 = MutableLiveData<String>()

	init {
		value1.value = "Hi there!"
	}
}
