package azadev.android.architecture.feat.part3

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewModel
import azadev.android.architecture.core.databinding.contentView
import azadev.android.architecture.databinding.Part3ActivityBinding

class Part3Activity : AppCompatActivity(), Part3LoginDialogFragment.Listener {

	private val binding by contentView<Part3ActivityBinding>(R.layout.part3_activity)
	private val model by viewModel<Part3ViewModel>()

	private val loginDialogFragment
		get() = supportFragmentManager.findFragmentByTag("LoginDialog") as? Part3LoginDialogFragment

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding.model = model

		model.loginDialogOpen.observe(this, Observer {
			if (it == true) {
				openLoginDialog()
			}
			else {
				closeLoginDialog()
			}
		})
	}

	private fun openLoginDialog() {
		loginDialogFragment
				?: Part3LoginDialogFragment().show(supportFragmentManager, "LoginDialog")
	}

	private fun closeLoginDialog() {
		loginDialogFragment?.dismiss()
	}

	override fun onLogin(username: String) {
		model.handleSuccessfulLogin(username)
	}

	override fun onCancel() {
		model.handleCancelledLogin()
	}
}
