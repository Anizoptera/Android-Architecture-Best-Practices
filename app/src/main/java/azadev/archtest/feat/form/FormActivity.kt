package azadev.archtest.feat.form

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import azadev.archtest.R
import azadev.archtest.core.arch.viewModel
import azadev.archtest.core.databinding.contentView
import azadev.archtest.databinding.FormActivityBinding

class FormActivity : AppCompatActivity(), FormPresenter.FormPresenterView {

	private val binding by contentView<FormActivityBinding>(R.layout.form_activity)
	private val model by viewModel<FormViewModel>()
	private lateinit var presenter: FormPresenter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		presenter = FormPresenter(this, model)

		binding.setLifecycleOwner(this)
		binding.model = model
		binding.presenter = presenter
	}

	override fun showSuccessMessage() {
		Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
	}
}
