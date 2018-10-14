package azadev.android.architecture.feat.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import azadev.android.architecture.R
import azadev.android.architecture.databinding.MainActivityBinding
import azadev.android.architecture.feat.form.FormActivity
import azadev.android.architecture.feat.list.ListActivity

class MainActivity : AppCompatActivity(), MainPresenter {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)

		binding.presenter = this
	}

	override fun goToFormActivity() {
		startActivity(Intent(this, FormActivity::class.java))
	}

	override fun goToListActivity() {
		startActivity(Intent(this, ListActivity::class.java))
	}
}
