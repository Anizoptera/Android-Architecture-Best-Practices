package azadev.android.architecture.feat.part4

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import azadev.android.architecture.core.utils.randomHash

class Part4ViewModel(val app: Application) : AndroidViewModel(app) {

	private val dao get() = Part4Database.getDatabase(app).itemDao()

	val allItems = dao.getAll()
	val oddItems = dao.getOdd()

	fun handleAddItemClick() {
		addItems()
	}

	fun handleAdd5ItemsClick() {
		addItems(5)
	}

	fun handleRemoveAllClick() {
		dao.deleteAll()
	}

	private fun addItems(count: Int = 1) {
		(1..count).forEach {
			val item = Part4ItemEntity(title = randomHash(5..10))
			dao.insert(item)
		}
	}
}
