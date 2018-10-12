package azadev.archtest.feat.form

import azadev.archtest.core.utils.uiThread
import java.util.*
import kotlin.concurrent.schedule

class FormPresenter(val view: FormPresenterView, val model: FormViewModel) {
	fun save() {
		model.loading.value = true

		Timer().schedule(3000) {
			uiThread {
				model.loading.value = false
				view.showSuccessMessage()
			}
		}
	}

	interface FormPresenterView {
		fun showSuccessMessage()
	}
}
