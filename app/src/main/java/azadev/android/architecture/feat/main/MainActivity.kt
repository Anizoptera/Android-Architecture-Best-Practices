package azadev.android.architecture.feat.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import azadev.android.architecture.R
import azadev.android.architecture.databinding.MainActivityBinding
import azadev.android.architecture.feat.part1.Part1Activity
import azadev.android.architecture.feat.part2.Part2Activity

class MainActivity : AppCompatActivity(), MainPresenter {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)

		binding.presenter = this
	}

	override fun goToPart1Activity() {
		startActivity(Intent(this, Part1Activity::class.java))
	}

	override fun goToPart2Activity() {
		startActivity(Intent(this, Part2Activity::class.java))
	}
}
