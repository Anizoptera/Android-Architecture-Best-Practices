package azadev.android.architecture.core.utils

private val BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

fun Byte.toBase(base: Int) = (this.toInt() and 255).toBase(base)
fun Int.toBase(base: Int) = toLong().toBase(base)
fun Long.toBase(base: Int): String {
	val sb = StringBuilder()
	var value = this

	do {
		sb.insert(0, BASE62[(value % base).toInt()])
		value /= base
	}
	while (value > 0L)

	return sb.toString()
}
