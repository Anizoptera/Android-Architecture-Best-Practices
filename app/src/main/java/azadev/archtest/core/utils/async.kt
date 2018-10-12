package azadev.archtest.core.utils

import android.os.Handler
import android.os.Looper

val UI_HANDLER = Handler(Looper.getMainLooper())
val UI_THREAD = Looper.getMainLooper().thread!!

fun uiThread(f: () -> Unit) {
	if (Thread.currentThread() !== UI_THREAD) {
		UI_HANDLER.post(f)
	}
	else {
		f()
	}
}
