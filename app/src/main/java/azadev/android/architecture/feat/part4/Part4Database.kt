package azadev.android.architecture.feat.part4

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Part4ItemEntity::class], version = 1)
abstract class Part4Database : RoomDatabase() {

	abstract fun itemDao(): Part4ItemDao


	companion object {

		private var INSTANCE: Part4Database? = null

		fun getDatabase(context: Context): Part4Database {
			return INSTANCE ?: synchronized(Part4Database::class.java) {
				INSTANCE = INSTANCE ?: Room.databaseBuilder(
					context.applicationContext,
					Part4Database::class.java, "part4"
				).allowMainThreadQueries().build()

				return INSTANCE!!
			}
		}
	}
}
