package azadev.android.architecture.feat.part2

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import azadev.android.architecture.databinding.Part2ItemBinding

typealias AdapterData = List<Int>

class Part2ListAdapter(
	private val model: Part2ViewModel,
	private var data: AdapterData = emptyList()
) : RecyclerView.Adapter<Part2ListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Part2ListAdapter.ViewHolder {
		val binding = Part2ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return Part2ListAdapter.ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: Part2ListAdapter.ViewHolder, position: Int) {
		val id = data[position]

		holder.binding.model = model

		holder.binding.id = id
		holder.binding.title.text = "Item $id"
	}

	override fun getItemCount() = data.size

	fun setData(newData: AdapterData) {
		val diffResult = DiffUtil.calculateDiff(DiffCallback(data, newData))
		data = newData
		diffResult.dispatchUpdatesTo(this)
	}

	class ViewHolder(val binding: Part2ItemBinding) : RecyclerView.ViewHolder(binding.root)

	class DiffCallback(
		private val oldData: AdapterData,
		private val newData: AdapterData
	) : DiffUtil.Callback() {

		override fun getOldListSize() = oldData.size

		override fun getNewListSize() = newData.size

		override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			oldData[oldItemPosition] == newData[newItemPosition]

		override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			areItemsTheSame(oldItemPosition, newItemPosition)
	}
}
