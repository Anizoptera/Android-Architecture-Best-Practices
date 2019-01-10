package azadev.android.architecture.feat.part1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewmodel.viewModel
import azadev.android.architecture.core.databinding.inflaters.contentView
import azadev.android.architecture.databinding.Part1ActivityBinding

class Part1Activity : AppCompatActivity() {

	private val model by viewModel<Part1ViewModel>()
	private val binding by contentView<Part1ActivityBinding>(R.layout.part1_activity)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding.model = model

		model.successMessageCommand.observe(this) {
			showSuccessMessage()
		}
	}

	private fun showSuccessMessage() {
		Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
	}
}
