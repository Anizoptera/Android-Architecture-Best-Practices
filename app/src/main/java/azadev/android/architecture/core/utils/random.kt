package azadev.android.architecture.core.utils

import java.security.SecureRandom

private val random = SecureRandom()

fun random(min: Double = .0, max: Double = 100.0): Double {
	if (min >= max) throw IllegalArgumentException("random: $min >= $max")
	val rand = random
	return synchronized(rand) { rand.nextDouble() } * (max - min) + min
}

fun randomInt(min: Int = 0, max: Int = 100): Int {
	if (min >= max) {
		if (min == max) return max
		throw IllegalArgumentException("randomInt: $min >= $max")
	}
	val rand = random
	return synchronized(rand) { rand.nextInt((max - min) + 1) } + min
}

fun randomBytes(size: Int): ByteArray {
	val bytes = ByteArray(size)
	random.nextBytes(bytes)
	return bytes
}

fun randomHash(length: Int, base: Int = 36): String {
	val bytes = randomBytes(length)
	val chars = CharArray(length) {
		((bytes[it] + 128) * base / 255).toBase(base)[0]
	}
	return String(chars)
}

fun randomHash(lengthRange: IntRange, base: Int = 36): String {
	val length = randomInt(lengthRange.start, lengthRange.endInclusive)
	return randomHash(length, base)
}
