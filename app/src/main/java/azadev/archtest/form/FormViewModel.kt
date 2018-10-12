package azadev.archtest.form

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class FormViewModel : ViewModel() {
	var value1 = MutableLiveData<String>()

	init {
		value1.value = "Hi there!"
	}
}
