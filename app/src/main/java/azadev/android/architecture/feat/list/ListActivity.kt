package azadev.android.architecture.feat.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import azadev.android.architecture.R
import azadev.android.architecture.core.arch.viewModel
import azadev.android.architecture.core.databinding.livedata.contentView
import azadev.android.architecture.databinding.ListActivityBinding

class ListActivity : AppCompatActivity() {

	private val binding by contentView<ListActivityBinding>(R.layout.list_activity)
	private val model by viewModel<ListViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val listAdapter = ListAdapter(model.items.value!!, model)

		binding.model = model

		binding.recyclerView.layoutManager = LinearLayoutManager(this)
		binding.recyclerView.adapter = listAdapter

		model.items.observe(this, Observer { list ->
			listAdapter.setData(list!!)
		})
	}
}
