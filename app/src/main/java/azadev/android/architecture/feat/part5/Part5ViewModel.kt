package azadev.android.architecture.feat.part5

import android.arch.lifecycle.ViewModel
import azadev.android.architecture.core.arch.livedata.mediatorLiveData
import azadev.android.architecture.core.arch.livedata.mutableLiveData
import kotlin.concurrent.thread

private const val CHUNK_SIZE = 5

class Part5ViewModel : ViewModel() {
	private var multiplier = -1

	val items = mutableLiveData(generateItems())

	val selectedCount = mediatorLiveData(items) { items.value!!.count { it.isSelected } }

	fun handleAddClick() {
		items.value = items.value!! + generateItems()
	}

	fun handleRemoveClick() {
		items.value = items.value!!.filter { !it.isSelected }
	}

	fun handleSelectAllClick() {
		val value = items.value!!
		val selectedAll = value.all { it.isSelected }

		items.value = value.map { it.copy(isSelected = !selectedAll) }
	}

	fun handleCheckboxClick(itemId: Int) {
		items.value = items.value!!.map {
			if (it.id == itemId) it.copy(isLoading = true) else it
		}

		thread {
			Thread.sleep(2000)

			items.postValue(items.value!!.map {
				if (it.id == itemId) it.copy(isSelected = !it.isSelected, isLoading = false) else it
			})
		}
	}

	private fun generateItems(): List<Part5ListItemData> {
		multiplier++

		return (1..CHUNK_SIZE).map {
			val id = CHUNK_SIZE * multiplier + it

			Part5ListItemData(
				id = id,
				name = "Item $id"
			)
		}
	}
}
