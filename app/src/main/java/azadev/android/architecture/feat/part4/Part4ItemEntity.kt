package azadev.android.architecture.feat.part4

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "item")
data class Part4ItemEntity(
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	var id: Int = 0,

	@ColumnInfo(name = "title")
	var title: String = ""
)
