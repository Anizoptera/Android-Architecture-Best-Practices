package azadev.android.architecture.feat.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import azadev.android.architecture.R
import azadev.android.architecture.core.databinding.contentView
import azadev.android.architecture.core.view.MATCH_PARENT
import azadev.android.architecture.core.view.WRAP_CONTENT
import azadev.android.architecture.databinding.MainActivityBinding
import azadev.android.architecture.feat.part1.Part1Activity
import azadev.android.architecture.feat.part2.Part2Activity
import azadev.android.architecture.feat.part3.Part3Activity
import azadev.android.architecture.feat.part4.Part4Activity
import azadev.android.architecture.feat.part5.Part5Activity

private val PARTS = arrayOf(
	"1. Simple Form" to Part1Activity::class.java,
	"2. Simple Reactive List" to Part2Activity::class.java,
	"3. Dialogs" to Part3Activity::class.java,
	"4. Room Database" to Part4Activity::class.java,
	"5. Interactive List" to Part5Activity::class.java
)

class MainActivity : AppCompatActivity() {

	private val binding by contentView<MainActivityBinding>(R.layout.main_activity)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding.parts.removeAllViews()

		PARTS.forEach { part ->
			Button(this).let { button ->
				button.text = part.first
				button.setOnClickListener {
					startActivity(Intent(this, part.second))
				}

				binding.parts.addView(button, MATCH_PARENT, WRAP_CONTENT)
			}
		}
	}
}
