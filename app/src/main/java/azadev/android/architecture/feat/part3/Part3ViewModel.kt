package azadev.android.architecture.feat.part3

import android.arch.lifecycle.ViewModel
import azadev.android.architecture.core.arch.livedata.mutableLiveData

class Part3ViewModel : ViewModel() {
	val isLoginDialogOpen = mutableLiveData(false)

	val username = mutableLiveData<String>(null)

	fun handleLoginButtonClick() {
		isLoginDialogOpen.value = true
	}

	fun handleSuccessfulLogin(username: String) {
		this.username.value = username
		isLoginDialogOpen.value = false
	}

	fun handleCancelledLogin() {
		isLoginDialogOpen.value = false
	}
}
