package azadev.android.architecture.feat.part3

import android.arch.lifecycle.ViewModel
import azadev.android.architecture.core.databinding.livedata.mutableLiveData

class Part3ViewModel : ViewModel() {
	val loginDialogOpen = mutableLiveData(false)

	val username = mutableLiveData<String>(null)

	fun handleLoginButtonClick() {
		loginDialogOpen.value = true
	}

	fun handleSuccessfulLogin(username: String) {
		this.username.value = username
		loginDialogOpen.value = false
	}

	fun handleCancelledLogin() {
		loginDialogOpen.value = false
	}
}
