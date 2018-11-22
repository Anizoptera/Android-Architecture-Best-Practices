package azadev.android.architecture.feat.part5

data class Part5ListItemData(
	val id: Int,
	val name: String,
	val isSelected: Boolean = false,
	val isLoading: Boolean = false
)
