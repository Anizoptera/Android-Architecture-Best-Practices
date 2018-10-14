package azadev.android.architecture.feat.part2

import android.arch.lifecycle.ViewModel
import azadev.android.architecture.core.databinding.livedata.mutableLiveData

private const val CHUNK_SIZE = 5

class Part2ViewModel : ViewModel() {
	private var multiplier = -1

	val items = mutableLiveData(generateItems())

	fun handleAddClick() {
		items.value = items.value!! + generateItems()
	}

	fun handleRemoveClick(id: Int) {
		items.value = items.value!!.filter { it != id }
	}

	private fun generateItems(): List<Int> {
		multiplier++
		return (1..CHUNK_SIZE).map { CHUNK_SIZE * multiplier + it }
	}
}
