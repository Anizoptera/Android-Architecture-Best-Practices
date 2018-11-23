package azadev.android.architecture.feat.part4

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewModel
import azadev.android.architecture.core.databinding.contentView
import azadev.android.architecture.databinding.Part4ActivityBinding

class Part4Activity : AppCompatActivity() {

	private val model by viewModel<Part4ViewModel>()
	private val binding by contentView<Part4ActivityBinding>(R.layout.part4_activity)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding.model = model

		setupRecyclerView(binding.recyclerViewOfAll, model.allItems)
		setupRecyclerView(binding.recyclerViewOfOdd, model.oddItems)
	}

	private fun setupRecyclerView(recyclerView: RecyclerView, data: LiveData<AdapterData>) {
		val adapter = Part4ListAdapter()

		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.adapter = adapter

		data.observe(this, Observer {
			adapter.setData(it!!)
		})
	}
}
