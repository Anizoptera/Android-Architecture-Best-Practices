package azadev.archtest.feat.form

import android.arch.lifecycle.ViewModel
import azadev.archtest.core.databinding.SingleLiveEvent
import azadev.archtest.core.databinding.mediatorLiveData
import azadev.archtest.core.databinding.mutableLiveData
import azadev.archtest.core.utils.uiThread
import java.util.*
import kotlin.concurrent.schedule

class FormViewModel : ViewModel() {
	val title = mutableLiveData("")
	val description = mutableLiveData("")
	val showPreview = mutableLiveData(false)
	val loading = mutableLiveData(false)

	val saveButtonEnabled = mediatorLiveData(title, loading) {
		!title.value.isNullOrEmpty() && loading.value != true
	}

	val successMessageCommand = SingleLiveEvent<Void>()

	fun save() {
		loading.value = true

		Timer().schedule(3000) {
			uiThread {
				loading.value = false
				successMessageCommand.call()
			}
		}
	}
}
