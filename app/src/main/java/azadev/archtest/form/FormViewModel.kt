package azadev.archtest.form

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class FormViewModel : ViewModel() {
	var title = MutableLiveData<String>()
	var description = MutableLiveData<String>()
	var showPreview = MutableLiveData<Boolean>()
	var isLoading = MutableLiveData<Boolean>()

	init {
		title.value = ""
		description.value = ""
		showPreview.value = false
		isLoading.value = false
	}
}
