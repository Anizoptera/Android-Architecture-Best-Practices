package azadev.android.architecture.feat.part4

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface Part4ItemDao {
	@Query("SELECT * FROM item ORDER BY id ASC")
	fun getAll(): LiveData<List<Part4ItemEntity>>

	@Query("SELECT * FROM item WHERE ([id] % 2) <> 0 ORDER BY id ASC")
	fun getOdd(): LiveData<List<Part4ItemEntity>>

	@Insert
	fun insert(itemEntity: Part4ItemEntity)

	@Query("DELETE FROM item")
	fun deleteAll()
}
