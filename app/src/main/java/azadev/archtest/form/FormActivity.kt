package azadev.archtest.form

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import azadev.archtest.R
import azadev.archtest.databinding.FormActivityBinding

class FormActivity : AppCompatActivity(), FormPresenter.FormPresenterView {

	private lateinit var binding: FormActivityBinding
	private lateinit var model: FormViewModel
	private lateinit var presenter: FormPresenter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = DataBindingUtil.setContentView(this, R.layout.form_activity)
		model = ViewModelProviders.of(this)[FormViewModel::class.java]
		presenter = FormPresenter(this, model)

		binding.setLifecycleOwner(this)
		binding.model = model
		binding.presenter = presenter
	}

	override fun showSuccessMessage() {
		Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
	}
}
