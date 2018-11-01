package azadev.android.architecture.feat.part2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewModel
import azadev.android.architecture.core.databinding.contentView
import azadev.android.architecture.databinding.Part2ActivityBinding

class Part2Activity : AppCompatActivity() {

	private val binding by contentView<Part2ActivityBinding>(R.layout.part2_activity)
	private val model by viewModel<Part2ViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding.model = model

		binding.recyclerView.layoutManager = LinearLayoutManager(this)
		binding.recyclerView.adapter = Part2ListAdapter(this, model)
	}
}
