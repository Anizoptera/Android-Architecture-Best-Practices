package azadev.android.architecture.feat.part1

import android.arch.lifecycle.ViewModel
import azadev.android.architecture.core.databinding.livedata.SingleLiveEvent
import azadev.android.architecture.core.databinding.livedata.mediatorLiveData
import azadev.android.architecture.core.databinding.livedata.mutableLiveData
import azadev.android.architecture.core.utils.uiThread
import java.util.*
import kotlin.concurrent.schedule

class Part1ViewModel : ViewModel() {
	val title = mutableLiveData("")
	val description = mutableLiveData("")
	val showPreview = mutableLiveData(false)
	val loading = mutableLiveData(false)

	val saveButtonEnabled = mediatorLiveData(title, loading) {
		!title.value.isNullOrEmpty() && loading.value != true
	}

	val successMessageCommand = SingleLiveEvent<Void>()

	fun handleSaveClick() {
		loading.value = true

		Timer().schedule(3000) {
			uiThread {
				loading.value = false
				successMessageCommand.call()
			}
		}
	}
}
