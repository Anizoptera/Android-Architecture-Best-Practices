package azadev.archtest.feat.form

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import azadev.archtest.R
import azadev.archtest.core.arch.viewModel
import azadev.archtest.core.databinding.contentView
import azadev.archtest.databinding.FormActivityBinding

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
