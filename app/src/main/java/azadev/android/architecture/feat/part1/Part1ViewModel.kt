package azadev.android.architecture.feat.part1

import android.arch.lifecycle.ViewModel
import azadev.android.architecture.core.arch.livedata.SingleLiveEvent
import azadev.android.architecture.core.arch.livedata.mediatorLiveData
import azadev.android.architecture.core.arch.livedata.mutableLiveData
import azadev.android.architecture.core.utils.uiThread
import java.util.*
import kotlin.concurrent.schedule

class Part1ViewModel : ViewModel() {
	val title = mutableLiveData("")
	val description = mutableLiveData("")

	val isPreviewShown = mutableLiveData(false)

	val isLoading = mutableLiveData(false)

	val isSaveButtonEnabled = mediatorLiveData(title, isLoading) {
		!title.value.isNullOrEmpty() && isLoading.value != true
	}

	val successMessageCommand = SingleLiveEvent<Void>()

	fun handleSaveClick() {
		isLoading.value = true

		Timer().schedule(3000) {
			uiThread {
				isLoading.value = false
				successMessageCommand.call()
			}
		}
	}
}
