package azadev.android.architecture.feat.list

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import azadev.android.architecture.databinding.ListItemBinding

typealias AdapterData = List<Int>

class ListAdapter(
		private var data: AdapterData,
		private val model: ListViewModel
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
		val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
		return ListAdapter.ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
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

	class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.main)

	class DiffCallback(
			private val oldData: AdapterData,
			private val newData: AdapterData
	) : DiffUtil.Callback() {

		override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
				oldData[oldItemPosition] == newData[newItemPosition]

		override fun getOldListSize() = oldData.size

		override fun getNewListSize() = newData.size

		override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
				oldData[oldItemPosition] == newData[newItemPosition]
	}
}
