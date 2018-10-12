package azadev.archtest.form

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import azadev.archtest.R
import azadev.archtest.databinding.FormActivityBinding

class FormActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = DataBindingUtil.setContentView<FormActivityBinding>(this, R.layout.form_activity)

		val model = ViewModelProviders.of(this)[FormViewModel::class.java]

		binding.setLifecycleOwner(this)
		binding.model = model
	}
}
