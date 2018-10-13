package azadev.android.architecture.feat.form

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewModel
import azadev.android.architecture.core.databinding.livedata.contentView
import azadev.android.architecture.databinding.FormActivityBinding

class FormActivity : AppCompatActivity() {

	private val binding by contentView<FormActivityBinding>(R.layout.form_activity)
	private val model by viewModel<FormViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding.setLifecycleOwner(this)
		binding.model = model

		model.successMessageCommand.observe(this) {
			showSuccessMessage()
		}
	}

	private fun showSuccessMessage() {
		Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
	}
}
