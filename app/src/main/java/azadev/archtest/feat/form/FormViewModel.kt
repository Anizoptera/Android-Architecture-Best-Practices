package azadev.archtest.feat.form

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class FormViewModel : ViewModel() {
	val title = MutableLiveData<String>()
	val description = MutableLiveData<String>()
	val showPreview = MutableLiveData<Boolean>()
	val loading = MutableLiveData<Boolean>()

	val saveButtonEnabled = MediatorLiveData<Boolean>()

	init {
		title.value = ""
		description.value = ""
		showPreview.value = false
		loading.value = false

		saveButtonEnabled.addSource(title) { _ -> saveButtonEnabled.value = !title.value.isNullOrEmpty() && loading.value != true }
		saveButtonEnabled.addSource(loading) { _ -> saveButtonEnabled.value = !title.value.isNullOrEmpty() && loading.value != true }
	}
}
