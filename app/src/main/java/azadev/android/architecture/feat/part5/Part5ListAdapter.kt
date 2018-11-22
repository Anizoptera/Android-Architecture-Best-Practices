package azadev.android.architecture.feat.part5

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import azadev.android.architecture.databinding.Part5ItemBinding

typealias AdapterData = List<Part5ListItemData>

class Part5ListAdapter(
	private val model: Part5ViewModel,
	private var data: AdapterData = emptyList()
) : RecyclerView.Adapter<Part5ListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Part5ListAdapter.ViewHolder {
		val binding = Part5ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return Part5ListAdapter.ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: Part5ListAdapter.ViewHolder, position: Int) {
		holder.binding.model = model
		holder.binding.data = data[position]
	}

	override fun getItemCount() = data.size

	fun setData(newData: AdapterData) {
		val diffResult = DiffUtil.calculateDiff(DiffCallback(data, newData))
		data = newData
		diffResult.dispatchUpdatesTo(this)
	}

	class ViewHolder(val binding: Part5ItemBinding) : RecyclerView.ViewHolder(binding.root)

	class DiffCallback(
		private val oldData: AdapterData,
		private val newData: AdapterData
	) : DiffUtil.Callback() {

		override fun getOldListSize() = oldData.size

		override fun getNewListSize() = newData.size

		override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			oldData[oldItemPosition].id == newData[newItemPosition].id

		override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			oldData[oldItemPosition].isSelected == newData[newItemPosition].isSelected
					&& oldData[oldItemPosition].isLoading == newData[newItemPosition].isLoading
	}
}
