package azadev.android.architecture.feat.part1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewModel
import azadev.android.architecture.core.databinding.livedata.contentView
import azadev.android.architecture.databinding.Part1ActivityBinding

class Part1Activity : AppCompatActivity() {

	private val binding by contentView<Part1ActivityBinding>(R.layout.part1_activity)
	private val model by viewModel<Part1ViewModel>()

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
