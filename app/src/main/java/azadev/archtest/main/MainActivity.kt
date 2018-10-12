package azadev.archtest.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import azadev.archtest.R
import azadev.archtest.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)

		val model = ViewModelProviders.of(this)[MainViewModel::class.java]

		binding.setLifecycleOwner(this)
		binding.model = model
	}
}
