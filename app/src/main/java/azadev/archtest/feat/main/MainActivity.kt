package azadev.archtest.feat.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import azadev.archtest.R
import azadev.archtest.databinding.MainActivityBinding
import azadev.archtest.feat.form.FormActivity

class MainActivity : AppCompatActivity(), MainPresenter {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)

		binding.presenter = this
	}

	override fun goToFormActivity() {
		startActivity(Intent(this, FormActivity::class.java))
	}
}
