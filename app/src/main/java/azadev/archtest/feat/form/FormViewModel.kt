package azadev.archtest.feat.form

import android.arch.lifecycle.ViewModel
import azadev.archtest.core.databinding.mediatorLiveData
import azadev.archtest.core.databinding.mutableLiveData

class FormViewModel : ViewModel() {
	val title = mutableLiveData("")
	val description = mutableLiveData("")
	val showPreview = mutableLiveData(false)
	val loading = mutableLiveData(false)

	val saveButtonEnabled = mediatorLiveData(title, loading) {
		!title.value.isNullOrEmpty() && loading.value != true
	}
}
