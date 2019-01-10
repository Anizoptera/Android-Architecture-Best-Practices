package azadev.android.architecture.feat.part5

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewmodel.viewModel
import azadev.android.architecture.core.databinding.inflaters.contentView
import azadev.android.architecture.databinding.Part5ActivityBinding

class Part5Activity : AppCompatActivity() {

	private val model by viewModel<Part5ViewModel>()
	private val binding by contentView<Part5ActivityBinding>(R.layout.part5_activity)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding.model = model

		val adapter = Part5ListAdapter(model)

		binding.recyclerView.layoutManager = LinearLayoutManager(this)
		binding.recyclerView.adapter = adapter

		model.items.observe(this, Observer {
			adapter.setData(it!!)
		})
	}
}
