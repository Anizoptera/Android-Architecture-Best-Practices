package azadev.android.architecture.feat.part4

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import azadev.android.architecture.databinding.Part4ItemBinding

typealias AdapterData = List<Part4ItemEntity>

class Part4ListAdapter(
	private var data: AdapterData = emptyList()
) : RecyclerView.Adapter<Part4ListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Part4ListAdapter.ViewHolder {
		val binding = Part4ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return Part4ListAdapter.ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: Part4ListAdapter.ViewHolder, position: Int) {
		holder.binding.item = data[position]
	}

	override fun getItemCount() = data.size

	fun setData(newData: AdapterData) {
		val diffResult = DiffUtil.calculateDiff(DiffCallback(data, newData))
		data = newData
		diffResult.dispatchUpdatesTo(this)
	}

	class ViewHolder(val binding: Part4ItemBinding) : RecyclerView.ViewHolder(binding.root)

	class DiffCallback(
		private val oldData: AdapterData,
		private val newData: AdapterData
	) : DiffUtil.Callback() {

		override fun getOldListSize() = oldData.size

		override fun getNewListSize() = newData.size

		override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			oldData[oldItemPosition].id == newData[newItemPosition].id

		override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
			oldData[oldItemPosition] == newData[newItemPosition]
	}
}
