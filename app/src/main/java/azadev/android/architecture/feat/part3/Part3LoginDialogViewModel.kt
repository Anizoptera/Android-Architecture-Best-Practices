package azadev.android.architecture.feat.part3

import android.arch.lifecycle.ViewModel
import azadev.android.architecture.core.arch.livedata.SingleLiveEvent
import azadev.android.architecture.core.arch.livedata.mutableLiveData
import azadev.android.architecture.core.utils.uiThread
import java.util.*
import kotlin.concurrent.schedule

class Part3LoginDialogViewModel : ViewModel() {
	val username = mutableLiveData("")
	val password = mutableLiveData("")

	val remember = mutableLiveData(true)

	val isLoading = mutableLiveData(false)

	val validationErrorCommand = SingleLiveEvent<Void>()

	val loggedInCommand = SingleLiveEvent<Void>()
	val cancelledCommand = SingleLiveEvent<Void>()

	fun handleLoginButtonClick() {
		if (username.value.isNullOrBlank() || password.value.isNullOrBlank()) {
			validationErrorCommand.call()
			return
		}

		isLoading.value = true

		Timer().schedule(3000) {
			uiThread {
				isLoading.value = false
				loggedInCommand.call()
			}
		}
	}

	fun handleCancel() {
		cancelledCommand.call()
	}
}
